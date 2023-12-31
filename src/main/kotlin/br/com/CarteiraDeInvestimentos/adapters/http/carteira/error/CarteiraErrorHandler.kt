package br.com.CarteiraDeInvestimentos.adapters.http.carteira.error

import br.com.CarteiraDeInvestimentos.application.carteira.exception.CarteiraNaoEncontradaException
import mu.KotlinLogging

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.UUID

private val LOGGER = KotlinLogging.logger { }

@ControllerAdvice
class ErrorHandler() {
    @ExceptionHandler(Exception::class)
    fun handlerException(ex: Exception): ResponseEntity<CarteiraErrorResponse> {
        return ex.toServerResponse()
    }
}

private fun Throwable.toResponse(): Pair<HttpStatus, CarteiraErrorResponse> =
        when (this) {
            is CarteiraNaoEncontradaException -> toResponse(
                    usuario =  this.usuario,
                    statusCode = HttpStatus.NOT_FOUND,
            )

            else ->   toResponse(
                    statusCode = HttpStatus.BAD_REQUEST,
            )
        }

private fun Throwable.toResponse(
        usuario: String? = null,
        statusCode: HttpStatus,
        message: String = this.message ?: "",
): Pair<HttpStatus, CarteiraErrorResponse> {
    val response = CarteiraErrorResponse(

            message = message,
    )

    val fullMessage = "[${statusCode.value()}] [${this.javaClass.simpleName}] $message"
    if (statusCode.is5xxServerError) {
        LOGGER.error(this) { fullMessage }
    } else {
        LOGGER.warn { fullMessage }
    }

    return statusCode to response
}

fun Throwable.toServerResponse(): ResponseEntity<CarteiraErrorResponse> {
    val (statusCode, response) = toResponse()
    return ResponseEntity.status(statusCode).body(response)
}