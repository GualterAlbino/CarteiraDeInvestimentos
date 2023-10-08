package br.com.CarteiraDeInvestimentos.domain.transacao

import java.util.UUID

class Transacao (
        val id: UUID = UUID.randomUUID(),
        val ticket : String,
        val usuario: String,
        val tipo: String,  //TransacaoTipo -  Ação, FII, BDR e etc
        val operacao: String, //TransacaoOperacao -  Compra, venda e etc
        val descricao: String,
        val quantidade: Int,
        val valorUnitario: Double,
        val valorTotal: Double,
        val dataHora: String

)