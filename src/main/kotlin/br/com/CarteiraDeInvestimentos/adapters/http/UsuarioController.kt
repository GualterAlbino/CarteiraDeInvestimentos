package br.com.CarteiraDeInvestimentos.adapters.http


import br.com.CarteiraDeInvestimentos.application.usuario.UsuarioCreateComand
import br.com.CarteiraDeInvestimentos.application.usuario.UsuarioUpdateComand
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private const val UUID_REGEX = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}"

@RestController
class UsuarioController(
        private val usuarioHandler: UsuarioHandler
) {
    @GetMapping("/usuario")
    fun findAll():ResponseEntity<List<Usuario>>{
        return usuarioHandler.findAll();
    }

    @GetMapping("/usuario/{usuarioId}") //:$UUID_REGEX
    fun findById(@PathVariable usuarioId: String): ResponseEntity<Usuario>{
        return usuarioHandler.findById(usuarioId)
    }

    @PostMapping("/usuario")
    fun inserir(@RequestBody usuario: UsuarioCreateComand):ResponseEntity<Usuario>{
        return usuarioHandler.inserir(usuario)
    }

    @DeleteMapping("/usuario/{usuarioId}")
    fun excluir(@PathVariable usuarioId: String):ResponseEntity<String>{
        return usuarioHandler.excluir(usuarioId)
    }

    @PatchMapping("/usuario/{usuarioId}")
    fun atualizar(@RequestBody transacao: UsuarioUpdateComand, @PathVariable usuarioId: String):ResponseEntity<Usuario>{
        return usuarioHandler.atualizar(transacao, usuarioId)
    }





}