package br.com.boraviajar.apimanager.model.updateagency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAgencyAddressResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("estado")
    private String state;

    @JsonProperty("cep")
    private String zipCode;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("logradouro")
    private String address;

    @JsonProperty("numero")
    private String number;

    @JsonProperty("complemento")
    private String complement;
}
