package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.travel.UpdatedTravelDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class TravelEntityToUpdatedTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static UpdatedTravelDomain translate(final TravelEntity travelEntity) {
        return MAPPER.map(travelEntity, UpdatedTravelDomain.class);
    }

}
