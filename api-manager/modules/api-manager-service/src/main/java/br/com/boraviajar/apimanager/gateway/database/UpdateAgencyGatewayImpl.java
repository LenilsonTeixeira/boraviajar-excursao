package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.agency.UpdateAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.UpdatedAgencyDomain;
import br.com.boraviajar.apimanager.gateway.UpdateAgencyGateway;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import br.com.boraviajar.apimanager.gateway.database.repository.AgencyRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.AgencyEntityToUpdatedAgencyDomainTranslator;
import br.com.boraviajar.apimanager.gateway.database.translator.UpdateAgencyDomainToAgencyEntityTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("updateAgencyGatewayImpl")
public class UpdateAgencyGatewayImpl implements UpdateAgencyGateway {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public UpdatedAgencyDomain update(UpdateAgencyDomain updateAgencyDomain) {

        final AgencyEntity agencyEntity = UpdateAgencyDomainToAgencyEntityTranslator.translate(updateAgencyDomain);

        return AgencyEntityToUpdatedAgencyDomainTranslator.translate(agencyRepository.save(agencyEntity));
    }
}
