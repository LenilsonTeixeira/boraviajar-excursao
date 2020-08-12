package br.com.boraviajar.apifinder.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Travel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("destino")
    private String destination;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("cidadeOrigem")
    private String departureCity;

    @JsonProperty("dataPartida")
    private LocalDate departureDate;

    @JsonProperty("dataRetorno")
    private LocalDate returnDate;

    @JsonProperty("horarioSaida")
    private LocalTime departureTime;

    @JsonProperty("horarioRetorno")
    private LocalTime returnTime;

    @JsonProperty("preco")
    private BigDecimal price;

    @JsonIgnore
    private String agencyId;
}
