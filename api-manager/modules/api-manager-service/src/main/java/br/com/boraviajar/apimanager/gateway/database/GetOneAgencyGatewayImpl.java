package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;
import br.com.boraviajar.apimanager.gateway.GetOneAgencyGateway;
import br.com.boraviajar.apimanager.gateway.database.repository.AgencyRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.AgencyEntityToObtainedAgencyDomainTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("getOneAgencyGatewayImpl")
public class GetOneAgencyGatewayImpl implements GetOneAgencyGateway {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public Optional<ObtainedAgencyDomain> get(final String id) {

        return agencyRepository.findById(id)
                .map(AgencyEntityToObtainedAgencyDomainTranslator::translate);
    }
}
