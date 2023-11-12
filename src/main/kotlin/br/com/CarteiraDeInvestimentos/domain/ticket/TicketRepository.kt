package br.com.CarteiraDeInvestimentos.domain.ticket

import br.com.CarteiraDeInvestimentos.domain.carteira.Carteira

interface TicketRepository {

    fun findByTicket(): Ticket? //Ao utilizar ? deixa condicional
}