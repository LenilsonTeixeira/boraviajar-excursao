package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.agency.AddedAgencyDomain;
import br.com.boraviajar.apimanager.model.addagency.AgencyResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddedAgencyDomainToAgencyResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AgencyResponse translate(final AddedAgencyDomain addedAgencyDomain) {
        return MAPPER.map(addedAgencyDomain, AgencyResponse.class);
    }

}
