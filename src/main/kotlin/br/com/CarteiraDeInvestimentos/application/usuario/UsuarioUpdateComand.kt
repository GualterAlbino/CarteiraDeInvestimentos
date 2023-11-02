package br.com.CarteiraDeInvestimentos.application.usuario

import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import kotlinx.serialization.Serializable
import java.util.*


@Serializable
data class UsuarioUpdateComand(
        val nome :String,
        val email:String,
        val senha:String
)

fun UsuarioUpdateComand.toUsuario(usuarioId: UUID, encoderPassword: EncoderPassword) = Usuario(
        id = usuarioId,
        nome = nome,
        email = email,
        senha = encoderPassword.encode(senha),
)