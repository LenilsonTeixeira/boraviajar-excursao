package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.travel.AddTravelDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddTravelDomainToTravelEntityTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static TravelEntity translate(final AddTravelDomain addTravelDomain) {

        final TravelEntity travelEntity = MAPPER.map(addTravelDomain, TravelEntity.class);

        return travelEntity;
    }
}
