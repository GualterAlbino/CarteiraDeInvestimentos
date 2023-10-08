package br.com.CarteiraDeInvestimentos.domain.transacao

interface TransacaoRepository {

    fun findAll(): List<Transacao>
}