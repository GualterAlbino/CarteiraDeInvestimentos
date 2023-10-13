package br.com.CarteiraDeInvestimentos.application.transacao

import br.com.CarteiraDeInvestimentos.application.transacao.exceptions.TransacaoNaoEncontradaException
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import br.com.CarteiraDeInvestimentos.domain.transacao.TransacaoRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TransacaoService(
        private val transacaoRepository: TransacaoRepository
) {

    fun findAll(): List<Transacao>{
        return transacaoRepository.findAll()
    }

    fun findById(transacaoId: UUID): Transacao {
        return transacaoRepository.findById(transacaoId) ?: throw TransacaoNaoEncontradaException(transacaoId)
    }

    fun inserir(transacao: TransacaoCreateComand): Transacao {

        val transacaoDomain = transacao.toTransacao()

        transacaoRepository.inserir(transacao = transacaoDomain)

        return findById(transacaoDomain.id)
    }

    fun excluir(transacaoId: UUID) {
        transacaoRepository.findById(transacaoId = transacaoId) ?: throw  TransacaoNaoEncontradaException(transacaoId)

        transacaoRepository.excluir(transacaoId)
    }
}