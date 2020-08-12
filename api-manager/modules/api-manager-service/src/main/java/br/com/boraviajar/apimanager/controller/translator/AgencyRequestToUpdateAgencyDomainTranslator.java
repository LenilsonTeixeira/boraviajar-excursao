package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.agency.UpdateAgencyDomain;
import br.com.boraviajar.apimanager.model.updateagency.UpdateAgencyRequest;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AgencyRequestToUpdateAgencyDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static UpdateAgencyDomain translate(final String id, final UpdateAgencyRequest updateAgencyRequest) {

        final UpdateAgencyDomain updateAgencyDomain = MAPPER.map(updateAgencyRequest, UpdateAgencyDomain.class);

        updateAgencyDomain.setId(id);

        return updateAgencyDomain;
    }
}
