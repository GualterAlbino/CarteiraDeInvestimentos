package br.com.CarteiraDeInvestimentos.domain.carteira

class Carteira(
       val usuario: String,
       val ticket: String,
       val quantidade: Int,
       val valorUnitario: Double,
       val valorTotal: Double,
       val custoMedio: Double
)
