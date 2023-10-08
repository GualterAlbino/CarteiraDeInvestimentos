package br.com.CarteiraDeInvestimentos.adapters.jdbc

object TransacaoSqlExpressions {
    fun sqlSelectAll() = "SELECT * FROM transacao".trimIndent()


    fun sqlSelectById() = "SELECT * FROM transacao WHERE id = id".trimIndent()
}

