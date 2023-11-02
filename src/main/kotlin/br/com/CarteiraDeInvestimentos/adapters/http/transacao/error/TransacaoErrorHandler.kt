package br.com.catalogoprodutos.adapter.error

import br.com.CarteiraDeInvestimentos.adapters.http.transacao.error.TransacaoErrorResponse
import br.com.CarteiraDeInvestimentos.application.transacao.exceptions.TransacaoNaoEncontradaException
import br.com.CarteiraDeInvestimentos.application.usuario.exceptions.UsuarioNaoEncontradoException
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
    fun handlerException(ex: Exception): ResponseEntity<TransacaoErrorResponse> {
        return ex.toServerResponse()
    }
}

private fun Throwable.toResponse(): Pair<HttpStatus, TransacaoErrorResponse> =
        when (this) {
            is TransacaoNaoEncontradaException -> toResponse(
                    id = this.transacaoId,
                    statusCode = HttpStatus.NOT_FOUND,
            )

            is UsuarioNaoEncontradoException -> toResponse(
                    id = this.usuarioId,
                    statusCode = HttpStatus.NOT_FOUND
            )

            else -> {
                toResponse(
                        statusCode = HttpStatus.BAD_REQUEST,
                )
            }
        }

private fun Throwable.toResponse(
        id: UUID? = null,
        statusCode: HttpStatus,
        message: String = this.message ?: "",
): Pair<HttpStatus, TransacaoErrorResponse> {
    val response = TransacaoErrorResponse(
            id = id,
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

fun Throwable.toServerResponse(): ResponseEntity<TransacaoErrorResponse> {
    val (statusCode, response) = toResponse()
    return ResponseEntity.status(statusCode).body(response)
}