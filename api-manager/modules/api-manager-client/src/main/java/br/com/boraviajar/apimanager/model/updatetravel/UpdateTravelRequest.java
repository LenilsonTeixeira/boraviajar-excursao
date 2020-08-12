package br.com.boraviajar.apimanager.model.updatetravel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTravelRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O destino é obrigatório")
    @Size(min = 2, max = 80, message = "O destino deve conter no mínimo 2 e no máximo 80 caracteres")
    @JsonProperty("destino")
    private String destination;

    @NotEmpty(message = "A cidade de origem é obrigatória")
    @Size(min = 2, max = 150, message = "A cidade de origem deve conter no mínimo 2 e no máximo 150 caracteres")
    @JsonProperty("cidadeOrigem")
    private String departureCity;

    @NotEmpty(message = "A descricao é obrigatória")
    @Size(min = 250, message = "A descrição deve conter no mínimo  250 caracteres")
    @JsonProperty("descricao")
    private String description;

    @NotNull(message = "A data da partida é obrigatório")
    @JsonProperty("dataPartida")
    private LocalDate departureDate;

    @NotNull(message = "A data do retorno é obrigatório")
    @JsonProperty("dataRetorno")
    private LocalDate returnDate;

    @NotNull(message = "O horário de saida é obrigatório")
    @JsonProperty("horarioSaida")
    private LocalTime departureTime;

    @NotNull(message = "O horário de retorno é obrigatório")
    @JsonProperty("horarioRetorno")
    private LocalTime returnTime;

    @NotNull(message = "O preco é obrigatório")
    @JsonProperty("preco")
    private BigDecimal price;
}
