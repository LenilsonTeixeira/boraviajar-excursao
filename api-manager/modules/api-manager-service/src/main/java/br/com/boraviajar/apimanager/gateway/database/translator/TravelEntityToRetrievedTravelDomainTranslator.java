package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.travel.RetrievedTravelDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class TravelEntityToRetrievedTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static RetrievedTravelDomain translate(final TravelEntity travelEntity) {
        return MAPPER.map(travelEntity, RetrievedTravelDomain.class);
    }
}
