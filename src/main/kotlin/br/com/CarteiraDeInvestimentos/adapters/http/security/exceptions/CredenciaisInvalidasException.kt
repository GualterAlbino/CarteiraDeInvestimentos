package br.com.CarteiraDeInvestimentos.adapters.http.security.exceptions

sealed class CredenciaisException(message: String) : Exception(message)
class CredenciaisInvalidasException() : CredenciaisException("Usuário ou senha inválidos")