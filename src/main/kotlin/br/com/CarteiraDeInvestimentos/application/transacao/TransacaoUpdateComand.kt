package br.com.CarteiraDeInvestimentos.application.transacao

import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import kotlinx.serialization.Serializable
import java.util.*


@Serializable
data class TransacaoUpdateComand(
        val ticket :String,
        val usuario: String,
        val tipo: String,
        val operacao: String,
        val descricao: String,
        val quantidade: Int,
        val valor_unitario: Double,
        val valor_total: Double,
        val data_hora: String

)

fun TransacaoUpdateComand.toTransacao(id: UUID) = Transacao (
        id = id,
        ticket = ticket,
        usuario = usuario,
        tipo = tipo,
        operacao = operacao,
        descricao = descricao,
        quantidade = quantidade,
        valorUnitario = valor_unitario,
        valorTotal = valor_total,
        dataHora = data_hora
)