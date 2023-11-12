package br.com.CarteiraDeInvestimentos.adapters.jdbc.carteira

object CarteiraSqlExpressions {

    fun sqlInsertCarteira() = """INSERT INTO carteira.carteira(
	usuario, ticket, quantidade, valorunitario, valortotal, customedio)
	VALUES (:usuario , :ticket, :quantidade, :valorUnitario, :valorTotal, :custoMedio)""".trimIndent()
}