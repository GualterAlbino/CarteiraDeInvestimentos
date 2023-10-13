package br.com.CarteiraDeInvestimentos.domain.usuario

import java.util.UUID

class Usuario (
        val id: UUID = UUID.randomUUID(),
        val nome : String,
        val senha: String

)