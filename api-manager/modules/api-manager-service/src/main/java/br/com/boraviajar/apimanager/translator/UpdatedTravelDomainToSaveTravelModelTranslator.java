package br.com.boraviajar.apimanager.translator;

import br.com.boraviajar.apimanager.domain.travel.UpdatedTravelDomain;
import br.com.boraviajar.apimanager.gateway.messaging.model.SaveTravelModel;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UpdatedTravelDomainToSaveTravelModelTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static SaveTravelModel translate(final UpdatedTravelDomain updatedTravelDomain) {

        return MAPPER.map(updatedTravelDomain, SaveTravelModel.class);

    }

}
