package br.com.CarteiraDeInvestimentos.adapters.jdbc

object UsuarioSqlExpressions {
    fun sqlSelectAllUsuario() = "SELECT * FROM usuario".trimIndent()


    fun sqlSelectByIdUsuario() = "SELECT * FROM usuario WHERE id = :id".trimIndent()


    fun sqlInsertUsuario() = """
      INSERT INTO usuario (id, nome, senha)
      VALUES (:id, :nome, :senha);

    """.trimIndent()

    fun sqlDeleteUsuarioById() = """
        DELETE FROM usuario WHERE id = :id
    """.trimIndent()

    fun sqlUpdateUsuario() = """UPDATE usuario
        SET
        nome = :nome,
        senha = :senha
    """.trimIndent()

}

