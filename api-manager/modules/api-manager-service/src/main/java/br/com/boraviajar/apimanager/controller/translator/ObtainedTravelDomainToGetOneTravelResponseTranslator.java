package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.model.getonetravel.GetOneTravelResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class ObtainedTravelDomainToGetOneTravelResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static GetOneTravelResponse translate(final ObtainedTravelDomain obtainedTravelDomain) {

        return MAPPER.map(obtainedTravelDomain, GetOneTravelResponse.class);

    }

}
