package br.com.CarteiraDeInvestimentos.application.transacao.exceptions

import java.util.UUID

//Super Classe que sera usada para implementação das demais
sealed class TransacaoException(message: String): Exception(message) {
    abstract val transacaoId: UUID?
}


data class TransacaoNaoEncontradaException(
        override  val transacaoId: UUID?
) : TransacaoException("Transação: $transacaoId não encontrada.")
