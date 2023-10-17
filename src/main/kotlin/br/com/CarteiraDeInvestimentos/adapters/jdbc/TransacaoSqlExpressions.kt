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


    fun sqlDeleteById() = """
        DELETE FROM transacao WHERE id = :id
    """.trimIndent()

    fun sqlUpdateTransacao() = """UPDATE transacao
        SET
        ticket = :ticket,
        usuario = :usuario,
        tipo = :tipo, 
        operacao = :operacao, 
        descricao = :descricao, 
        quantidade = :quantidade, 
        valor_unitario = :valor_unitario, 
        valor_total = :valor_total, 
        data_hora = :data_hora
    """.trimIndent()

}

