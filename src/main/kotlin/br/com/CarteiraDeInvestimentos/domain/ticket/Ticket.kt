package br.com.CarteiraDeInvestimentos.domain.ticket

import java.math.BigDecimal
import java.time.LocalDateTime

class Ticket(
        val symbol: String,
        val currency: String,
        val twoHundredDayAverage: BigDecimal,
        val twoHundredDayAverageChange: BigDecimal,
        val twoHundredDayAverageChangePercent: BigDecimal,
        val marketCap: Long,
        val shortName: String,
        val longName: String,
        val regularMarketChange: BigDecimal,
        val regularMarketChangePercent: BigDecimal,
        val regularMarketTime: LocalDateTime,
        val regularMarketPrice: BigDecimal,
        val regularMarketDayHigh: BigDecimal,
        val regularMarketDayRange: String,
        val regularMarketDayLow: BigDecimal,
        val regularMarketVolume: Long,
        val regularMarketPreviousClose: BigDecimal,
        val regularMarketOpen: BigDecimal,
        val averageDailyVolume3Month: Long,
        val averageDailyVolume10Day: Long,
        val fiftyTwoWeekLowChange: BigDecimal,
        val fiftyTwoWeekLowChangePercent: BigDecimal,
        val fiftyTwoWeekRange: String,
        val fiftyTwoWeekHighChange: BigDecimal,
        val fiftyTwoWeekHighChangePercent: BigDecimal,
        val fiftyTwoWeekLow: BigDecimal,
        val fiftyTwoWeekHigh: BigDecimal,
        val priceEarnings: BigDecimal,
        val earningsPerShare: BigDecimal,
        val logoUrl: String,
        val updatedAt: LocalDateTime
)
