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
public class AgencyAddressRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo cidade é obrigatório")
    @Size(max = 30, message = "O cidade deve conter no máximo 30 caracteres")
    @JsonProperty("cidade")
    private String city;

    @NotEmpty(message = "O campo estado é obrigatório")
    @Size(min = 2, max = 2, message = "O estado deve conter 2 caracteres")
    @JsonProperty("estado")
    private String state;

    @NotEmpty(message = "O campo cep é obrigatório")
    @Size(min = 8, max = 8, message = "O cep deve conter 8 caracteres")
    @JsonProperty("cep")
    private String zipCode;

    @NotEmpty(message = "O campo bairro é obrigatório")
    @Size(max = 30, message = "O bairro deve conter no máximo 30 caracteres")
    @JsonProperty("bairro")
    private String neighborhood;

    @NotEmpty(message = "O campo logradouro é obrigatório")
    @Size(max = 80, message = "O logradouro deve conter no máximo 80 caracteres")
    @JsonProperty("logradouro")
    private String address;

    @NotEmpty(message = "O campo numero é obrigatório")
    @Size(max = 10, message = "O numero deve conter no máximo 10 caracteres")
    @JsonProperty("numero")
    private String number;

    @NotEmpty(message = "O campo complemento é obrigatório")
    @Size(max = 100, message = "O complemento deve conter no máximo 100 caracteres")
    @JsonProperty("complemento")
    private String complement;
}
