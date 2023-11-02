package br.com.CarteiraDeInvestimentos.adapters.jdbc.usuario

object UsuarioSqlExpressions {
    fun sqlSelectAllUsuario() = "SELECT * FROM usuario".trimIndent()


    fun sqlSelectByIdUsuario() = "SELECT * FROM usuario WHERE id = :id".trimIndent()


    fun sqlInsertUsuario() = """
      INSERT INTO usuario (id, nome, email, senha)
      VALUES (:id, :nome, :email, :senha);

    """.trimIndent()

    fun sqlDeleteUsuarioById() = """
        DELETE FROM usuario WHERE id = :id
    """.trimIndent()

    fun sqlSelectUsuarioByEmail() = """
        select 
            id,
            nome,
            email,
            senha
        from usuario
        WHERE email = :email
    """.trimIndent()


    fun sqlUpdateUsuario() = """UPDATE usuario
        SET
        nome = :nome,
        email = :email,
        senha = :senha
    """.trimIndent()

}

