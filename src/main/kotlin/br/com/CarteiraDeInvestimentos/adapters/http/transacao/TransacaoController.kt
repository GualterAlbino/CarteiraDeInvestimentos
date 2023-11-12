package br.com.CarteiraDeInvestimentos.adapters.http.transacao
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoCreateComand
import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoUpdateComand
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TransacaoController(
        private val transacaoHandler: TransacaoHandler
) {
    @GetMapping("/transacao")
    fun findAll(): ResponseEntity<List<Transacao>> {
        return transacaoHandler.findAll();
    }

    @GetMapping("/transacao/{transacaoId}") //:$UUID_REGEX
    fun findById(@PathVariable transacaoId: String): ResponseEntity<Transacao> {
        return transacaoHandler.findById(transacaoId)
    }

    @PostMapping("/transacao")
    fun inserir(@RequestBody transacao: TransacaoCreateComand): ResponseEntity<Transacao> {


        val emailUsuario = SecurityContextHolder.getContext().authentication.principal

        if(emailUsuario != null){
            transacao.usuario  = SecurityContextHolder.getContext().authentication.principal.toString()
        }


        return transacaoHandler.inserir(transacao)
    }


    @DeleteMapping("/transacao/{transacaoId}")
    fun excluir(@PathVariable transacaoId: String): ResponseEntity<String> {
        return transacaoHandler.excluir(transacaoId)
    }

    @PatchMapping("/transacao/{transacaoId}")
    fun atualizar(@RequestBody transacao: TransacaoUpdateComand, @PathVariable transacaoId: String): ResponseEntity<Transacao> {
        return transacaoHandler.atualizar(transacao, transacaoId)
    }






}