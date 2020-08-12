package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;
import br.com.boraviajar.apimanager.exception.AgencyNotFoundException;
import br.com.boraviajar.apimanager.gateway.GetOneAgencyGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Component
public class GetAgencyUseCase {

    @Autowired
    private GetOneAgencyGateway getOneAgencyGateway;

    public ObtainedAgencyDomain execute(@PathVariable("id") final String id) {

        log.debug("Consultando agência id: {}", id);

        return getOneAgencyGateway.get(id)
                .orElseThrow(() -> new AgencyNotFoundException(String.format("Agência id: %s não encontrada.", id)));

    }
}
