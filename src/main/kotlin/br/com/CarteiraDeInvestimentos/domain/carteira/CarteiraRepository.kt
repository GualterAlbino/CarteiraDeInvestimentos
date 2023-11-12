package br.com.CarteiraDeInvestimentos.domain.carteira

interface CarteiraRepository {

    fun findAll(): Carteira? //Ao utilizar ? deixa condicional

    fun inserir(carteira: Carteira): Boolean
}