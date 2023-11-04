package br.com.CarteiraDeInvestimentos.adapters.http.security.exceptions

import br.com.CarteiraDeInvestimentos.adapters.http.error.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.PrintWriter

@Component("customAuthenticationEntryPoint")
class CustomEntryPoint() : AuthenticationEntryPoint {
    override fun commence(
            request: HttpServletRequest?,
            response: HttpServletResponse,
            authException: AuthenticationException?,
    ) {
        val format = Json { ignoreUnknownKeys = true }
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.addHeader("Content-Type", "application/json")
        //response.writer.println("Falha!")
        //response.writer.write(format.encodeToString(ErrorResponse(message = "Authentication failed")))
        response.writer.write(ErrorResponse(message = "iyuiyui"))
    }
}

private fun PrintWriter.write(errorResponse: ErrorResponse) {
    TODO("Not yet implemented")
}
