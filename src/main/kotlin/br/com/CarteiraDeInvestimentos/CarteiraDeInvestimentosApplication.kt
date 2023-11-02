package br.com.CarteiraDeInvestimentos

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class CarteiraDeInvestimentosApplication

fun main(args: Array<String>) {
	//val message = Encoders.BASE64.encode(Jwts.SIG.HS512.key().build().encoded)
	//println(message)

	runApplication<CarteiraDeInvestimentosApplication>(*args)
}
