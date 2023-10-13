package br.com.CarteiraDeInvestimentos.application.usuario


import UsuarioRepository
import br.com.CarteiraDeInvestimentos.adapters.http.error.ErrorResponse
import br.com.CarteiraDeInvestimentos.application.usuario.exceptions.UsuarioNaoEncontradoException
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UsuarioService(
        private val usuarioRepository: UsuarioRepository
) {

    fun findAll(): List<Usuario>{
        return usuarioRepository.findAll()
    }

    fun findById(usuarioId: UUID): Usuario {
        return usuarioRepository.findById(usuarioId) ?: throw  UsuarioNaoEncontradoException(usuarioId)
    }

    fun inserir(usuario: UsuarioCreateComand): Usuario {

        val usuarioDomain = usuario.toUsuario()

        usuarioRepository.inserir(usuario = usuarioDomain)

        return findById(usuarioDomain.id)
    }
}