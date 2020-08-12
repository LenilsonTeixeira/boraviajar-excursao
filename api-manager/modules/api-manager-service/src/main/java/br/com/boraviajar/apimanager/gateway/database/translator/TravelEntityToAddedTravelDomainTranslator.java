package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.travel.AddedTravelDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class TravelEntityToAddedTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AddedTravelDomain translate(final TravelEntity travelEntity) {
        return MAPPER.map(travelEntity, AddedTravelDomain.class);
    }
}
