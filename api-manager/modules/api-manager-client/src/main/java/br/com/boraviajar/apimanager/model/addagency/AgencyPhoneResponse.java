package br.com.boraviajar.apimanager.model.addagency;

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
public class AgencyPhoneResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("ddd")
    private String ddd;

    @JsonProperty("numero")
    private String number;
}
