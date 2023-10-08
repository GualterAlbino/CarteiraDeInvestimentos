package br.com.CarteiraDeInvestimentos.adapters.http

import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoService
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class TransacaoHandler(
        private val transacaoService: TransacaoService
) {
    fun findAll(): ResponseEntity<List<Transacao>>{
        val transacoes = transacaoService.findAll()
        return ResponseEntity.ok(transacoes)
    }
}