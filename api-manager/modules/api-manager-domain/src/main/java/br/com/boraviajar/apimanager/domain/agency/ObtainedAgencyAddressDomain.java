package br.com.boraviajar.apimanager.domain.agency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObtainedAgencyAddressDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;
    private String state;
    private String zipCode;
    private String neighborhood;
    private String address;
    private String number;
    private String complement;
}
