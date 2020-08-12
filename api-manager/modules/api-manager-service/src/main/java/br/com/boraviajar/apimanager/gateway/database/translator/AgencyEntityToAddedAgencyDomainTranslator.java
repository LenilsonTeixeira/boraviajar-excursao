package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.agency.AddedAgencyDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AgencyEntityToAddedAgencyDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AddedAgencyDomain translate(final AgencyEntity agencyEntity) {
        return MAPPER.map(agencyEntity, AddedAgencyDomain.class);
    }
}
