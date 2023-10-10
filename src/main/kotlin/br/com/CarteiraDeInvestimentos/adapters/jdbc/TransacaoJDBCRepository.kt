package br.com.CarteiraDeInvestimentos.adapters.jdbc

import br.com.CarteiraDeInvestimentos.adapters.jdbc.TransacaoSqlExpressions.sqlInsertTransacao
import br.com.CarteiraDeInvestimentos.adapters.jdbc.TransacaoSqlExpressions.sqlSelectAll
import br.com.CarteiraDeInvestimentos.adapters.jdbc.TransacaoSqlExpressions.sqlSelectById
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import br.com.CarteiraDeInvestimentos.domain.transacao.TransacaoRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.logging.Logger
import javax.swing.tree.RowMapper

@Repository
class TransacaoJDBCRepository(private val db: NamedParameterJdbcOperations ) : TransacaoRepository{

    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun findAll(): List<Transacao> {
        //Que traço é esse depois de "rs, "?????????????
       val transacoes = db.query(sqlSelectAll(), rowMapper())
        return transacoes
    }

    override fun findById(transacaoId: UUID): Transacao? {
        try {
            val params = MapSqlParameterSource("id", transacaoId)
            val transacaoProcurada = db.query(sqlSelectById(), params, rowMapper()).firstOrNull();

            return transacaoProcurada;

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar a transação: ${ex.message}" }
            throw ex
        }

    }


    override fun inserir(transacao: Transacao): Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("id", transacao.id)
            params.addValue("ticket", transacao.ticket)
            params.addValue("usuario", transacao.usuario)
            params.addValue("tipo", transacao.tipo)
            params.addValue("operacao",transacao.operacao)
            params.addValue("descricao", transacao.descricao)
            params.addValue("quantidade",transacao.quantidade)
            params.addValue("valor_unitario", transacao.valorUnitario)
            params.addValue("valor_total",transacao.valorTotal)
            params.addValue("data_hora", transacao.dataHora)
            val linhasAfetadas = db.update(sqlInsertTransacao(),params)

            return linhasAfetadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao inserir a transação: ${ex.message}" }
            throw ex
        }
    }


    private fun rowMapper()= org.springframework.jdbc.core.RowMapper<Transacao> { rs, _ ->
        val transacaoId = UUID.fromString(rs.getString("id"))
        Transacao(
                id = transacaoId,
                ticket = rs.getString("ticket"),
                usuario = rs.getString("usuario"),
                tipo = rs.getString("tipo"),
                operacao = rs.getString("operacao"),
                descricao = rs.getString("descricao"),
                quantidade = rs.getInt("quantidade"),
                valorUnitario = rs.getDouble("valor_unitario"),
                valorTotal = rs.getDouble("valor_total"),
                dataHora = rs.getString("data_hora")
        )
    }



}