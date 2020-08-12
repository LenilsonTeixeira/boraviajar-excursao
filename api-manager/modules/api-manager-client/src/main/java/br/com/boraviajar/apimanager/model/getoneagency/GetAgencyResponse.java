package br.com.boraviajar.apimanager.model.getoneagency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAgencyResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cadastur")
    private String cadastur;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private List<GetAgencyPhoneResponse> phones;

    @JsonProperty("endereco")
    private GetAgencyAddressResponse address;

    @JsonProperty("responsavel")
    private String owner;

    @JsonProperty("site")
    private String website;

    @JsonProperty("facebook")
    private String facebook;

    @JsonProperty("instagram")
    private String instagram;
}
