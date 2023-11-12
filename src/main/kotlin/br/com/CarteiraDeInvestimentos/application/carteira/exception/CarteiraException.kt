package br.com.CarteiraDeInvestimentos.application.carteira.exception

//Super Classe que sera usada para implementação das demais
sealed class CarteiraException(message: String): Exception(message) {
    abstract val usuario: String?
}


data class CarteiraNaoEncontradaException(
        override  val usuario: String
) : CarteiraException("Carteira do usuario:: $usuario não encontrada.")
