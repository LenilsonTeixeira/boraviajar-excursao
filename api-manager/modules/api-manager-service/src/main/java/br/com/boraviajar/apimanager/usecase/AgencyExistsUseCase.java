package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.gateway.AgencyExistsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AgencyExistsUseCase {

    @Autowired
    private AgencyExistsGateway agencyExistsGateway;

    public boolean execute(final String id) {

        return this.agencyExistsGateway.exists(id);

    }
}
