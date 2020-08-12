package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.gateway.DeleteAgencyGateway;
import br.com.boraviajar.apimanager.gateway.database.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deleteAgencyGatewayImpl")
public class DeleteAgencyGatewayImpl implements DeleteAgencyGateway {

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public void delete(String id) {

        this.agencyRepository.deleteById(id);

    }
}
