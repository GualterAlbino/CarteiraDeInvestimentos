package br.com.CarteiraDeInvestimentos.domain.transacao

import java.util.UUID

interface TransacaoRepository {

    fun findAll(): List<Transacao>

    fun findById(transacaoId: UUID):Transacao? //Ao utilizar ? deixa condicional
}