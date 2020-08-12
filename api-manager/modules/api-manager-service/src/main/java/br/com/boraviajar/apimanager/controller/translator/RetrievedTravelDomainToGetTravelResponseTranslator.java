package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.RetrievedTravelDomain;
import br.com.boraviajar.apimanager.model.gettravel.GetTravelResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class RetrievedTravelDomainToGetTravelResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static GetTravelResponse translate(final RetrievedTravelDomain retrievedTravelDomain) {

        return MAPPER.map(retrievedTravelDomain, GetTravelResponse.class);

    }

}
