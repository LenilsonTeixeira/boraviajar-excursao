package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.agency.AddAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.AddedAgencyDomain;
import br.com.boraviajar.apimanager.gateway.AddAgencyGateway;
import br.com.boraviajar.apimanager.gateway.database.entity.agency.AgencyEntity;
import br.com.boraviajar.apimanager.gateway.database.repository.AgencyRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.AddAgencyDomainToAgencyEntityTranslator;
import br.com.boraviajar.apimanager.gateway.database.translator.AgencyEntityToAddedAgencyDomainTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addAgencyGatewayImpl")
public class AddAgencyGatewayImpl implements AddAgencyGateway {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public AddedAgencyDomain add(AddAgencyDomain addAgencyDomain) {

        final AgencyEntity agencyEntity = AddAgencyDomainToAgencyEntityTranslator.translate(addAgencyDomain);

        return AgencyEntityToAddedAgencyDomainTranslator.translate(agencyRepository.save(agencyEntity));
    }
}
