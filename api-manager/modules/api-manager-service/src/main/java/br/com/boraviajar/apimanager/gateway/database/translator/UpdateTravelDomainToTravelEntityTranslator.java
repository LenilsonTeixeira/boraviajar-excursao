package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.travel.UpdateTravelDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UpdateTravelDomainToTravelEntityTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static TravelEntity translate(final UpdateTravelDomain updateTravelDomain) {
        return MAPPER.map(updateTravelDomain, TravelEntity.class);
    }
}
