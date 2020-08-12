package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.exception.AgencyException;
import br.com.boraviajar.apimanager.gateway.DeleteAgencyGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Component
public class DeleteAgencyUseCase {

    @Autowired
    private GetAgencyUseCase getAgencyUseCase;

    @Autowired
    private DeleteAgencyGateway deleteAgencyGateway;

    public void execute(@PathVariable("id") final String id) {

        try {

            log.debug("Removendo agência com id: {}", id);

            Optional.ofNullable(getAgencyUseCase.execute(id)).ifPresent(agency -> deleteAgencyGateway.delete(id));

        }catch (final Exception e){

            log.error("Falha ao tentar excluir a agência {}. {}", id, e);

            throw new AgencyException(String.format("Ocorreu um erro ao tentar excluir a agência %s", id));

        }

    }
}
