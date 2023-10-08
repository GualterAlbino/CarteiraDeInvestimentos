package br.com.CarteiraDeInvestimentos.adapters.jdbc

import br.com.CarteiraDeInvestimentos.adapters.jdbc.TransacaoSqlExpressions.sqlSelectAll
import br.com.CarteiraDeInvestimentos.adapters.jdbc.TransacaoSqlExpressions.sqlSelectById
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import br.com.CarteiraDeInvestimentos.domain.transacao.TransacaoRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*
import javax.swing.tree.RowMapper

@Repository
class TransacaoJDBCRepository(private val db: NamedParameterJdbcOperations ) : TransacaoRepository{
    override fun findAll(): List<Transacao> {
        //Que traço é esse depois de "rs, "?????????????
       val transacoes = db.query(sqlSelectAll(), rowMapper())
        return transacoes
    }

    override fun findById(transacaoId: UUID): Transacao? {
       val params = MapSqlParameterSource("id", transacaoId)
        val transacaoProcurada = db.query(sqlSelectById(), params, rowMapper()).firstOrNull();

        return transacaoProcurada;
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