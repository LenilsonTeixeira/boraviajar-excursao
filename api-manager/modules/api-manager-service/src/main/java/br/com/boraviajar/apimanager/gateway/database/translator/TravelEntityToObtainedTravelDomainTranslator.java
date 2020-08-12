package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class TravelEntityToObtainedTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static ObtainedTravelDomain translate(final TravelEntity travelEntity) {
        return MAPPER.map(travelEntity, ObtainedTravelDomain.class);
    }
}
