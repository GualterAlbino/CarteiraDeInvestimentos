package br.com.CarteiraDeInvestimentos.adapters.jdbc

object TransacaoSqlExpressions {
    fun sqlSelectAll() = "SELECT * FROM transacao".trimIndent()
}