package br.com.CarteiraDeInvestimentos.adapters.jdbc

object UsuarioSqlExpressions {
    fun sqlSelectAllUsuario() = "SELECT * FROM usuario".trimIndent()


    fun sqlSelectByIdUsuario() = "SELECT * FROM usuario WHERE id = :id".trimIndent()


    fun sqlInsertUsuario() = """
      INSERT INTO usuario (id, nome, senha)
      VALUES (:id, :nome, :senha);

    """.trimIndent()

}

