package br.com.CarteiraDeInvestimentos.domain.transacao

import java.util.UUID

interface TransacaoRepository {

    fun findAll(): List<Transacao>

    fun findById(transacaoId: UUID):Transacao? //Ao utilizar ? deixa condicional

    fun inserir(transacao: Transacao): Boolean

    fun excluir(transacaoId: UUID):Boolean

    fun atualizar(transacao: Transacao):Boolean
}