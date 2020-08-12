package br.com.boraviajar.apimanager.translator;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.gateway.messaging.model.DeleteTravelModel;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class ObtainedTravelDomainToDeleteTravelModelTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static DeleteTravelModel translate(final ObtainedTravelDomain obtainedTravelDomain) {

        return MAPPER.map(obtainedTravelDomain, DeleteTravelModel.class);

    }

}
