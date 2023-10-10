package br.com.CarteiraDeInvestimentos.adapters.jdbc

object TransacaoSqlExpressions {
    fun sqlSelectAll() = "SELECT * FROM transacao".trimIndent()


    fun sqlSelectById() = "SELECT * FROM transacao WHERE id = :id".trimIndent()


    fun sqlInsertTransacao() = """
       INSERT INTO transacao(
           id,
           ticket,
           usuario, 
           tipo, 
           operacao, 
           descricao,
           quantidade,
           valor_unitario,
           valor_total,
           data_hora)
        values (
           :id,
           :ticket,
           :usuario,
           :tipo, 
           :operacao, 
           :descricao, 
           :quantidade, 
           :valor_unitario, 
           :valor_total, 
           :data_hora
        )
    """.trimIndent()

}

