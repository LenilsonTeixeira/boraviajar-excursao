package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.UpdatedTravelDomain;
import br.com.boraviajar.apimanager.model.updatetravel.UpdateTravelResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UpdatedTravelDomainToUpdateTravelResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static UpdateTravelResponse translate(final UpdatedTravelDomain updatedTravelDomain) {

        return MAPPER.map(updatedTravelDomain, UpdateTravelResponse.class);

    }
}
