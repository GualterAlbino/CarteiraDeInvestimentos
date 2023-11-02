package br.com.CarteiraDeInvestimentos.adapters.http.security.response

import kotlinx.serialization.Serializable

@Serializable
data class Token(
        val accessToken: String
)