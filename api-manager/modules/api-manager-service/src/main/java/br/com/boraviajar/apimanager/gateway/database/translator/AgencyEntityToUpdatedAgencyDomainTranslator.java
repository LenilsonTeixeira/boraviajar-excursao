package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.agency.UpdatedAgencyDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AgencyEntityToUpdatedAgencyDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static UpdatedAgencyDomain translate(final AgencyEntity agencyEntity) {
        return MAPPER.map(agencyEntity, UpdatedAgencyDomain.class);
    }

}
