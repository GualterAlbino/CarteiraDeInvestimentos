package br.com.CarteiraDeInvestimentos.application.usuario


import UsuarioRepository
import br.com.CarteiraDeInvestimentos.application.usuario.exceptions.UsuarioNaoEncontradoException
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import org.springframework.stereotype.Service
import java.util.UUID

import org.springframework.security.core.userdetails.UserDetails
import br.com.CarteiraDeInvestimentos.adapters.http.security.UserDetailsSpringSecurity
import br.com.CarteiraDeInvestimentos.application.usuario.EncoderPassword
import org.springframework.security.core.userdetails.UserDetailsService

@Service
class UsuarioService(
        private val usuarioRepository: UsuarioRepository,
        private val encoderPassword: EncoderPassword,
) : UserDetailsService {

    fun findAll(): List<Usuario>{
        return usuarioRepository.findAll()
    }

    fun findById(usuarioId: UUID): Usuario? {
        return usuarioRepository.findById(usuarioId) ?: throw  UsuarioNaoEncontradoException(usuarioId)
    }

    fun findByEmail(email: String): Usuario? {
        return usuarioRepository.findByEmail(email)
    }

    fun inserir(usuario: UsuarioCreateComand): Usuario? {
        val usuarioDomain = usuario.toUsuario(encoderPassword = encoderPassword)
        usuarioRepository.inserir(usuario = usuarioDomain)
        return findById(usuarioDomain.id)
    }

    fun excluir(usuarioId: UUID) {
        usuarioRepository.findById(usuarioId = usuarioId) ?: throw  UsuarioNaoEncontradoException(usuarioId)

        usuarioRepository.excluir(usuarioId)
    }

    fun atualizar(usuario: UsuarioUpdateComand, usuarioId: UUID): Usuario? {
        usuarioRepository.findById(usuarioId = usuarioId) ?: throw UsuarioNaoEncontradoException(usuarioId = usuarioId)
        usuarioRepository.atualizar(usuario.toUsuario(usuarioId = usuarioId, encoderPassword = encoderPassword))
        return findById(usuarioId = usuarioId)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = usuarioRepository.findByEmail(username ?: "")
                ?: throw UsuarioNaoEncontradoException(username = username)

        return UserDetailsSpringSecurity(usuario)
    }
}