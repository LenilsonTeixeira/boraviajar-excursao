package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AgencyEntityToObtainedAgencyDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static ObtainedAgencyDomain translate(final AgencyEntity agencyEntity) {
        return MAPPER.map(agencyEntity, ObtainedAgencyDomain.class);
    }
}
