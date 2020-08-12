package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.gateway.AgencyExistsGateway;
import br.com.boraviajar.apimanager.gateway.database.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("agencyExistsGatewayImpl")
public class AgencyExistsGatewayImpl implements AgencyExistsGateway {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public boolean exists(String id) {

        return agencyRepository.existsById(id);

    }
}
