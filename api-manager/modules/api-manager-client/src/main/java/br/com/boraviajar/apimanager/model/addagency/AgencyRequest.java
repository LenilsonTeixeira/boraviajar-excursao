package br.com.boraviajar.apimanager.model.addagency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo nome é obrigatório")
    @Size(max = 80, message = "O nome deve conter no máximo 80 caracteres")
    @JsonProperty("nome")
    private String name;

    @NotEmpty(message = "O campo cadastur é obrigatório")
    @Size(min = 14, max = 20, message = "O cadastur deve conter no mínimo 14 e no máximo 20 caracteres")
    @JsonProperty("cadastur")
    private String cadastur;

    @NotEmpty(message = "O campo cnpj é obrigatório")
    @Size(min = 14, max = 20, message = "O cnpj deve conter no mínimo 14 e no máximo 20 caracteres")
    @JsonProperty("cnpj")
    private String cnpj;

    @NotEmpty(message = "O campo email é obrigatório")
    @Email(message = "Email inválido")
    @Size(max = 80, message = "O email deve conter no máximo 80 caracteres")
    @JsonProperty("email")
    private String email;

    @Valid
    @NotNull(message = "O campo telefone é obrigatório")
    @JsonProperty("telefone")
    private List<AgencyPhoneRequest> phones;

    @Valid
    @NotNull(message = "O campo endereco é obrigatório")
    @JsonProperty("endereco")
    private AgencyAddressRequest address;

    @NotEmpty(message = "O campo responsavel é obrigatório")
    @Size(max = 80, message = "O responsavel deve conter no máximo 80 caracteres")
    @JsonProperty("responsavel")
    private String owner;

    @Size(max = 40, message = "O campo site deve conter no máximo 40 caracteres")
    @JsonProperty("site")
    private String website;

    @Size(max = 40, message = "O campo facebook deve conter no máximo 40 caracteres")
    @JsonProperty("facebook")
    private String facebook;

    @Size(max = 40, message = "O campo instagram deve conter no máximo 40 caracteres")
    @JsonProperty("instagram")
    private String instagram;
}
