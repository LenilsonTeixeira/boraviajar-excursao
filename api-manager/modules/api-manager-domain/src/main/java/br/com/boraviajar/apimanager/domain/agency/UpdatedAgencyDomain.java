package br.com.boraviajar.apimanager.domain.agency;

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
public class UpdatedAgencyDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String cadastur;
    private String cnpj;
    private String email;
    private List<UpdatedAgencyPhoneDomain> phones;
    private UpdatedAgencyAddressDomain address;
    private String owner;
    private String website;
    private String facebook;
    private String instagram;
}
