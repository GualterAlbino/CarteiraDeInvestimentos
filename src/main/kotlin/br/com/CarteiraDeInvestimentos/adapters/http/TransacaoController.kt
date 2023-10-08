package br.com.CarteiraDeInvestimentos.adapters.http

import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TransacaoController(
        private val transacaoHandler: TransacaoHandler
) {
    @GetMapping("/transacao")
    fun findAll():ResponseEntity<List<Transacao>>{
        return transacaoHandler.findAll();
    }

    @GetMapping("/oi")
    fun teste(): String{
        return "Olá";

    }

}