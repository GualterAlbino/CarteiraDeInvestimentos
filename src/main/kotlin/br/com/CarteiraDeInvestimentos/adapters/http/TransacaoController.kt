package br.com.CarteiraDeInvestimentos.adapters.http

import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoCreateComand
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

private const val UUID_REGEX = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}"

@RestController
class TransacaoController(
        private val transacaoHandler: TransacaoHandler
) {
    @GetMapping("/transacao")
    fun findAll():ResponseEntity<List<Transacao>>{
        return transacaoHandler.findAll();
    }

    @GetMapping("/transacao/{transacaoId}") //:$UUID_REGEX
    fun findById(@PathVariable transacaoId: String): ResponseEntity<Transacao>{
        return transacaoHandler.findById(transacaoId)
    }

    @PostMapping("/transacao")
    fun inserir(@RequestBody transacao: TransacaoCreateComand):ResponseEntity<Transacao>{
        return transacaoHandler.inserir(transacao)
    }

    @DeleteMapping("/transacao/{transacaoId}")
    fun excluir(@PathVariable transacaoId: String):ResponseEntity<String>{
        return transacaoHandler.excluir(transacaoId)
    }






}