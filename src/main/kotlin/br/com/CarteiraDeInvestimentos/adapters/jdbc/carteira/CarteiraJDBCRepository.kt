package br.com.CarteiraDeInvestimentos.adapters.jdbc.carteira

import br.com.CarteiraDeInvestimentos.adapters.jdbc.transacao.TransacaoSqlExpressions
import br.com.CarteiraDeInvestimentos.domain.carteira.Carteira
import br.com.CarteiraDeInvestimentos.domain.carteira.CarteiraRepository
import mu.KotlinLogging

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository

@Repository
class CarteiraJDBCRepository (private val db: NamedParameterJdbcOperations ) : CarteiraRepository {

    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun inserir(carteira: Carteira): Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("usuario", carteira.usuario)
            params.addValue("ticket", carteira.ticket)
            params.addValue("quantidade", carteira.quantidade)
            params.addValue("valorunitario", carteira.valorUnitario)
            params.addValue("valortotal",carteira.valorTotal)
            params.addValue("customedio", carteira.custoMedio)

            val linhasAfetadas = db.update(TransacaoSqlExpressions.sqlInsertTransacao(),params)

            return linhasAfetadas > 0

        }catch (ex: Exception){
            //TransacaoJDBCRepository. { "Houve um erro ao inserir a transação: ${ex.message}" }
            throw ex
        }
    }

    override fun findAll(): Carteira? {
        TODO("Not yet implemented")
    }


}