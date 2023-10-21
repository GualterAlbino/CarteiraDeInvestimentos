package br.com.CarteiraDeInvestimentos.application.usuario

import br.com.CarteiraDeInvestimentos.domain.usuario.Usuario
import kotlinx.serialization.Serializable
import java.util.*


@Serializable
data class UsuarioUpdateComand(
        val nome :String,
        val senha:String
)

fun UsuarioUpdateComand.toUsuario(id: UUID) = Usuario (
        id = id,
        nome = nome,
        senha = senha
)