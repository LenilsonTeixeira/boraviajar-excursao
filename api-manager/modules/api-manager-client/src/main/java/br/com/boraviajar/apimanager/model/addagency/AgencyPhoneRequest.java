package br.com.boraviajar.apimanager.model.addagency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyPhoneRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo ddd é obrigatório")
    @Size(min = 2, max = 3, message = "O ddd deve conter no mínimo 2 e no máximo 3 caracteres")
    @JsonProperty("ddd")
    private String ddd;

    @NotEmpty(message = "O campo numero é obrigatório")
    @Size(min = 8, max = 9, message = "O numero deve conter entre 8 a 9 caracteres")
    @JsonProperty("numero")
    private String number;
}
