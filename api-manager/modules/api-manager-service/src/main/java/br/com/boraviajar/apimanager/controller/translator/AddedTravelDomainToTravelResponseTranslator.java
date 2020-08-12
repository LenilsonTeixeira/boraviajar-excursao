package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.AddedTravelDomain;
import br.com.boraviajar.apimanager.model.addtravel.TravelResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddedTravelDomainToTravelResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static TravelResponse translate(final AddedTravelDomain addedTravelDomain) {
        return MAPPER.map(addedTravelDomain, TravelResponse.class);
    }

}
