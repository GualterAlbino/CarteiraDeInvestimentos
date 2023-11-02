package br.com.CarteiraDeInvestimentos.application.usuario

import org.springframework.stereotype.Component
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Component
class BCryptEncoderPassword : EncoderPassword {
    private val bCryptPasswordEncoder: BCryptPasswordEncoder = BCryptPasswordEncoder()

    override fun encode(senha: String): String {
        return bCryptPasswordEncoder.encode(senha)
    }

    override fun matches(rawPassword: String, encodedPassword: String): Boolean {
        println("Nome: $rawPassword, Idade: $encodedPassword")
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword)
    }
}
