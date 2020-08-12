package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.agency.AddAgencyDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddAgencyDomainToAgencyEntityTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AgencyEntity translate(final AddAgencyDomain addAgencyDomain) {
        return MAPPER.map(addAgencyDomain, AgencyEntity.class);
    }

}
