package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;
import br.com.boraviajar.apimanager.model.getoneagency.GetAgencyResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class ObtainedAgencyDomainToGetAgencyResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static GetAgencyResponse translate(final ObtainedAgencyDomain obtainedAgencyDomain) {

        return MAPPER.map(obtainedAgencyDomain, GetAgencyResponse.class);

    }
}
