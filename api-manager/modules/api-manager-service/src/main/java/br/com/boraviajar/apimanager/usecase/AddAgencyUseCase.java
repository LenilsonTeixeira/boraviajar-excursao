package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.agency.AddAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.AddedAgencyDomain;
import br.com.boraviajar.apimanager.exception.AgencyException;
import br.com.boraviajar.apimanager.gateway.AddAgencyGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddAgencyUseCase {

    @Autowired
    private AddAgencyGateway addAgencyGateway;

    public AddedAgencyDomain execute(final AddAgencyDomain addAgencyDomain) {

        try {

            log.debug("Cadastrando agência: {}", addAgencyDomain);

            return addAgencyGateway.add(addAgencyDomain);

        } catch (final Exception e) {

            log.error(String.format("Falha ao salvar agência.: %s", e));

            throw new AgencyException(String.format("Ocorreu um erro ao salvar a agência %s.", addAgencyDomain.getName()));

        }
    }
}
