package br.com.CarteiraDeInvestimentos.application.usuario.exceptions

import java.util.UUID

//Super Classe que sera usada para implementação das demais
sealed class UsuarioException(message: String): Exception(message) {
    abstract val usuarioId: UUID?
}


data class UsuarioNaoEncontradoException(
        override  val usuarioId: UUID?
) : UsuarioException("Transação: $usuarioId não encontrado.")
