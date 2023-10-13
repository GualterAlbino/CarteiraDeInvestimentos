package br.com.CarteiraDeInvestimentos.application.usuario


import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import kotlinx.serialization.Serializable

@Serializable
data class UsuarioCreateComand(
        val nome :String,
        val senha:String


)

fun UsuarioCreateComand.toUsuario() = Usuario (
        nome = nome,
        senha = senha

)