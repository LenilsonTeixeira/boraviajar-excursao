package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.UpdateTravelDomain;
import br.com.boraviajar.apimanager.model.updatetravel.UpdateTravelRequest;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UpdateTravelRequestToUpdateTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static UpdateTravelDomain translate(final String id, final String agencyId, final UpdateTravelRequest updateTravelRequest) {

        final UpdateTravelDomain updateTravelDomain = MAPPER.map(updateTravelRequest, UpdateTravelDomain.class);

        updateTravelDomain.setId(id);

        updateTravelDomain.setAgencyId(agencyId);

        return updateTravelDomain;

    }
}
