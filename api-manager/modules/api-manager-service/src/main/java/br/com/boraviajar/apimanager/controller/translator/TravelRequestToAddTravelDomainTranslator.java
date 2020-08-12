package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.AddTravelDomain;
import br.com.boraviajar.apimanager.model.addtravel.TravelRequest;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class TravelRequestToAddTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AddTravelDomain translate(final String agency, final TravelRequest travelRequest) {

        final AddTravelDomain addTravelDomain = MAPPER.map(travelRequest, AddTravelDomain.class);

        addTravelDomain.setAgencyId(agency);

        return addTravelDomain;

    }

}
