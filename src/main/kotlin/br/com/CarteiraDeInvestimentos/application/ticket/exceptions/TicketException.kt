package br.com.CarteiraDeInvestimentos.application.ticket.exceptions

//Super Classe que sera usada para implementação das demais
sealed class TicketException(message: String): Exception(message) {
    abstract val ticket: String?
}


data class TicketNaoEncontradoException(
        override  val ticket: String
) : TicketException("Ticket: $ticket não encontrado.")
