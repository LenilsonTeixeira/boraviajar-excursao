package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.agency.AddAgencyDomain;
import br.com.boraviajar.apimanager.model.addagency.AgencyRequest;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AgencyRequestToAddAgencyDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AddAgencyDomain translate(final AgencyRequest agencyRequest) {
        return MAPPER.map(agencyRequest, AddAgencyDomain.class);
    }

}
