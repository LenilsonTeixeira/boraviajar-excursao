package br.com.boraviajar.apimanager.translator;

import br.com.boraviajar.apimanager.domain.travel.AddedTravelDomain;
import br.com.boraviajar.apimanager.gateway.messaging.model.SaveTravelModel;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddedTravelDomainToSaveTravelModelTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static SaveTravelModel translate(final AddedTravelDomain addedTravelDomain) {

        return MAPPER.map(addedTravelDomain, SaveTravelModel.class);

    }
}
