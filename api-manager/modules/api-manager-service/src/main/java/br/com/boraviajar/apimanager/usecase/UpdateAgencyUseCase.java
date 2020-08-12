package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.agency.ObtainedAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.UpdateAgencyDomain;
import br.com.boraviajar.apimanager.domain.agency.UpdatedAgencyDomain;
import br.com.boraviajar.apimanager.exception.AgencyException;
import br.com.boraviajar.apimanager.gateway.UpdateAgencyGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j
@Component
public class UpdateAgencyUseCase {

    @Autowired
    private GetAgencyUseCase getAgencyUseCase;

    @Autowired
    private UpdateAgencyGateway updateAgencyGateway;

    public UpdatedAgencyDomain execute(final UpdateAgencyDomain updateAgencyDomain) {

        try {

            log.debug("Atualizando agência id: {}", updateAgencyDomain.getId());

            ObtainedAgencyDomain obtainedAgencyDomain = getAgencyUseCase.execute(updateAgencyDomain.getId());

            Assert.notNull(obtainedAgencyDomain, "Agência não pode ser nulo.");

            return updateAgencyGateway.update(updateAgencyDomain);

        } catch (final Exception e) {

            log.error(String.format("Falha ao atualizar agência id: %s. %s", updateAgencyDomain.getId(), e));

            throw new AgencyException(String.format("Ocorreu um erro ao atualizar a agência: %s.", updateAgencyDomain.getName()));
        }
    }
}
