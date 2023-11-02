package br.com.CarteiraDeInvestimentos.adapters.http.transacao

import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoCreateComand
import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoService
import br.com.CarteiraDeInvestimentos.application.transacao.TransacaoUpdateComand
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class TransacaoHandler(
        private val transacaoService: TransacaoService
) {
    fun findAll(): ResponseEntity<List<Transacao>>{
        val transacoes = transacaoService.findAll()
        return ResponseEntity.ok(transacoes)
    }

    fun findById(transacaoId: String): ResponseEntity<Transacao>{

        val transacaoProcurada = transacaoService.findById(UUID.fromString(transacaoId))

        return ResponseEntity.ok(transacaoProcurada)
    }

    fun inserir(transacaoCreateComand: TransacaoCreateComand): ResponseEntity<Transacao>{
       val transacao = transacaoService.inserir(transacaoCreateComand)
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao)
    }

    fun excluir(transacaoId : String):ResponseEntity<String>{
        transacaoService.excluir(transacaoId = UUID.fromString(transacaoId))
        return ResponseEntity.noContent().build()
    }

    fun atualizar(transacaoUpdateComand: TransacaoUpdateComand, transacaoId: String):ResponseEntity<Transacao>{
        val transacao = transacaoService.atualizar(transacaoUpdateComand, UUID.fromString(transacaoId))
        return ResponseEntity.ok(transacao)
    }
}