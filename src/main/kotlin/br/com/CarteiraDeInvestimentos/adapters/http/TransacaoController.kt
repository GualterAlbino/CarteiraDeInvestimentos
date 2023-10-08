package br.com.CarteiraDeInvestimentos.adapters.http

import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/transacao/{transacaoId:$UUID_REGEX}")
    fun findById(@PathVariable transacaoId: String): ResponseEntity<Transacao>{
        return transacaoHandler.findById(transacaoId)
    }






}