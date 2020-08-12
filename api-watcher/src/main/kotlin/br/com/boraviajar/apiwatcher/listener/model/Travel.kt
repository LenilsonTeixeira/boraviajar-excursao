package br.com.boraviajar.apiwatcher.listener.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

data class Travel(

        @JsonProperty("id")
        val id: String,

        @JsonProperty("destino")
        val destination: String,

        @JsonProperty("cidadeOrigem")
        val departureCity: String,

        @JsonProperty("descricao")
        val description: String,

        @JsonProperty("dataPartida")
        val departureDate: LocalDate,

        @JsonProperty("dataRetorno")
        val returnDate: LocalDate,

        @JsonProperty("horarioSaida")
        val departureTime: LocalTime,

        @JsonProperty("horarioRetorno")
        val returnTime: LocalTime,

        @JsonProperty("preco")
        val price: BigDecimal
)