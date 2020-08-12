package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.agency.UpdateAgencyDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class UpdateAgencyDomainToAgencyEntityTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AgencyEntity translate(final UpdateAgencyDomain updateAgencyDomain) {
        return MAPPER.map(updateAgencyDomain, AgencyEntity.class);
    }
}
