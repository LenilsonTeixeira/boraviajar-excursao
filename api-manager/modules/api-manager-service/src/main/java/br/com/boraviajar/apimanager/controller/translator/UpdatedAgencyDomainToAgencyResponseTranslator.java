package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.agency.UpdatedAgencyDomain;
import br.com.boraviajar.apimanager.model.updateagency.UpdateAgencyResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UpdatedAgencyDomainToAgencyResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static UpdateAgencyResponse translate(final UpdatedAgencyDomain updatedAgencyDomain) {

        return MAPPER.map(updatedAgencyDomain, UpdateAgencyResponse.class);

    }

}
