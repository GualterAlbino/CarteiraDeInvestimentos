package br.com.CarteiraDeInvestimentos.adapters.http


import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoUpdateComand
import br.com.CarteiraDeInvestimentos.application.usuario.UsuarioCreateComand
import br.com.CarteiraDeInvestimentos.application.usuario.UsuarioService
import br.com.CarteiraDeInvestimentos.application.usuario.UsuarioUpdateComand
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class UsuarioHandler(
        private val usuarioService: UsuarioService
) {
    fun findAll(): ResponseEntity<List<Usuario>>{
        val usuarios = usuarioService.findAll()
        return ResponseEntity.ok(usuarios)
    }

    fun findById(usuarioId: String): ResponseEntity<Usuario>{

        val usuarioProcurado = usuarioService.findById(UUID.fromString(usuarioId))

        return ResponseEntity.ok(usuarioProcurado)
    }

    fun inserir(usuarioCreateComand: UsuarioCreateComand): ResponseEntity<Usuario>{
        val usuario = usuarioService.inserir(usuarioCreateComand)
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario)
    }

    fun excluir(usuarioId: String):ResponseEntity<String>{
        usuarioService.excluir(usuarioId = UUID.fromString(usuarioId))
        return ResponseEntity.noContent().build()
    }

    fun atualizar(usuarioUpdateComand: UsuarioUpdateComand, usuarioId: String):ResponseEntity<Usuario>{
        val transacao = usuarioService.atualizar(usuarioUpdateComand, UUID.fromString(usuarioId))
        return ResponseEntity.ok(transacao)
    }
}