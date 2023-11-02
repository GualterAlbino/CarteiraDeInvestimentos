package br.com.CarteiraDeInvestimentos.application.usuario


import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import kotlinx.serialization.Serializable

@Serializable
data class UsuarioCreateComand(
        val nome :String,
        val email :String,
        val senha:String
)

fun UsuarioCreateComand.toUsuario(encoderPassword: EncoderPassword) = Usuario(
        nome = nome,
        email = email,
        senha = encoderPassword.encode(senha),
)