package br.com.CarteiraDeInvestimentos.application.transacao

import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import br.com.CarteiraDeInvestimentos.domain.transacao.TransacaoRepository
import org.springframework.stereotype.Service

@Service
class TransacaoService(
        private val transacaoRepository: TransacaoRepository
) {

    fun findAll(): List<Transacao>{
        return transacaoRepository.findAll()
    }
}