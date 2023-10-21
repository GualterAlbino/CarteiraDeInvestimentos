package br.com.CarteiraDeInvestimentos.adapters.jdbc


import UsuarioRepository
import br.com.CarteiraDeInvestimentos.adapters.jdbc.UsuarioSqlExpressions.sqlInsertUsuario
import br.com.CarteiraDeInvestimentos.adapters.jdbc.UsuarioSqlExpressions.sqlSelectAllUsuario
import br.com.CarteiraDeInvestimentos.adapters.jdbc.UsuarioSqlExpressions.sqlSelectByIdUsuario
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario

import mu.KotlinLogging
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository

import java.util.*


@Repository
class UsuarioJDBCRepository(private val db: NamedParameterJdbcOperations ) : UsuarioRepository{

    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun findAll(): List<Usuario> {
        val usuarios = db.query(sqlSelectAllUsuario(), rowMapper())
        return usuarios
    }

    override fun findById(usuarioId: UUID): Usuario? {
        try {
            val params = MapSqlParameterSource("id", usuarioId)
            val usuarioProcurado = db.query(sqlSelectByIdUsuario(), params, rowMapper()).firstOrNull();

            return usuarioProcurado;

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar o usuario: ${ex.message}" }
            throw ex
        }

    }


    override fun inserir(usuario: Usuario): Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("id", usuario.id)
            params.addValue("nome", usuario.nome)
            params.addValue("senha", usuario.senha)

            val linhasAfetadas = db.update(sqlInsertUsuario(),params)

            return linhasAfetadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro o usuario: ${ex.message}" }
            throw ex
        }
    }

    override fun atualizar(usuario: Usuario):Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("id", usuario.id)
            params.addValue("nome", usuario.nome)
            params.addValue("senha", usuario.senha)

            val linhasAfestadas = db.update(UsuarioSqlExpressions.sqlUpdateUsuario(), params)

            return linhasAfestadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao atualizar a transação: ${ex.message}" }
            throw ex
        }
    }

    override fun excluir(usuarioId: UUID): Boolean {
        try {

            val params = MapSqlParameterSource("id", usuarioId)
            val linhasExcluidas = db.update(UsuarioSqlExpressions.sqlDeleteUsuarioById(), params)

            return linhasExcluidas == 1

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao excluir a transação: ${ex.message}" }
            throw ex
        }
    }


    private fun rowMapper()= org.springframework.jdbc.core.RowMapper<Usuario> { rs, _ ->
        val usuarioId = UUID.fromString(rs.getString("id"))
        Usuario(
                id = usuarioId,
                nome = rs.getString("nome"),
                senha = rs.getString("senha")


        )
    }



}