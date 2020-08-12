package br.com.boraviajar.apimanager.model.updatetravel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTravelResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("destino")
    private String destination;

    @JsonProperty("cidadeOrigem")
    private String departureCity;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("dataPartida")
    private LocalDate departureDate;

    @JsonProperty("dataRetorno")
    private LocalDate returnDate;

    @JsonProperty("horarioSaida")
    private LocalTime departureTime;

    @JsonProperty("horarioRetorno")
    private LocalTime returnTime;

}
