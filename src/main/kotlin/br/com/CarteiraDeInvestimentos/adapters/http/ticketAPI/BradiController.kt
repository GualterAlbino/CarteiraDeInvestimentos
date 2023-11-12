import br.com.CarteiraDeInvestimentos.domain.ticket.Ticket
import br.com.CarteiraDeInvestimentos.domain.transacao.Transacao
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@Service
class BradiController(private val restTemplate: RestTemplate) {


    fun obterStoquePreco(@PathVariable TICKET: String): ResponseEntity<Ticket>? {
        val TOKEN = "qKyvtAun1bHaLUheg9cdxU"
        val apiUrl = "https://brapi.dev/api/quote/$TICKET?token=$TOKEN"

        try {
            val response = restTemplate.getForObject(apiUrl, String::class.java)
            println(response)


            val objectMapper = ObjectMapper()
            val ticket: Ticket? = objectMapper.readValue(response, Ticket::class.java)

            return ResponseEntity.ok(ticket)
        } catch (e: Exception) {
            e.printStackTrace()
        }

      return null
    }


    @GetMapping("/ticket/{TICKET}")
    fun obterCotacaoAtual(@PathVariable TICKET: String): BigDecimal? {
        val TOKEN = "qKyvtAun1bHaLUheg9cdxU"
        val apiUrl = "https://brapi.dev/api/quote/$TICKET?token=$TOKEN"

        try {
            val response = restTemplate.getForObject(apiUrl, String::class.java)
            println(response)

            // ObjectMapper para desserializar a resposta diretamente para a classe Ticket
            val objectMapper = ObjectMapper()
            val ticket: Ticket? = objectMapper.readValue(response, Ticket::class.java)

            // Retorna o preço
            return ticket?.regularMarketPrice
        } catch (e: Exception) {

            e.printStackTrace()
        }

        return null
    }
}

