package br.com.CarteiraDeInvestimentos.adapters.http


import br.com.CarteiraDeInvestimentos.application.usuario.UsuarioCreateComand
import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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






}