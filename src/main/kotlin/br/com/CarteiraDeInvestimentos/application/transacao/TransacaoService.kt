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

    fun inserir(transacao: TransacaoCreateComand): Transacao? {

        val transacaoDomain = transacao.toTransacao()

        transacaoDomain?.let { transacaoRepository.inserir(transacao = it) }

        if (transacaoDomain != null) {
            return findById(transacaoDomain.id)
        }
        return null
    }

    fun excluir(transacaoId: UUID) {
        transacaoRepository.findById(transacaoId = transacaoId) ?: throw  TransacaoNaoEncontradaException(transacaoId)

        transacaoRepository.excluir(transacaoId)
    }

    fun atualizar(transacao: TransacaoUpdateComand, transacaoId: UUID):Transacao {
        transacaoRepository.findById(transacaoId)?: throw  TransacaoNaoEncontradaException(transacaoId)
        transacaoRepository.atualizar(transacao.toTransacao(transacaoId))

        return findById(transacaoId = transacaoId)
    }
}
