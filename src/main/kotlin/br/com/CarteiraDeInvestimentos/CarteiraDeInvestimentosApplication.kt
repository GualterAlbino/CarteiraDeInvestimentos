package br.com.CarteiraDeInvestimentos


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate


@SpringBootApplication
class CarteiraDeInvestimentosApplication

@Bean
fun restTemplate(): RestTemplate {
	return RestTemplate()
}

fun main(args: Array<String>) {
	//val message = Encoders.BASE64.encode(Jwts.SIG.HS512.key().build().encoded)
	//println(message)

	runApplication<CarteiraDeInvestimentosApplication>(*args)
}
