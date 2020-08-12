package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.exception.TravelException;
import br.com.boraviajar.apimanager.gateway.DeleteTravelGateway;
import br.com.boraviajar.apimanager.translator.ObtainedTravelDomainToDeleteTravelModelTranslator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Component
public class DeleteTravelUseCase {

    @Autowired
    private GetOneTravelUseCase getOneTravelUseCase;

    @Autowired
    private PublishDeleteTravelUseCase publishDeleteTravelUseCase;

    @Autowired
    private DeleteTravelGateway deleteTravelGateway;

    public void execute(@PathVariable("id") final String id) {

        try {

            final ObtainedTravelDomain obtainedTravelDomain = getOneTravelUseCase.execute(id);

            Assert.notNull(obtainedTravelDomain, "A consulta deve retornar uma Viagem.");

            log.debug("Removendo viagem com id: {}", id);

            deleteTravelGateway.delete(id);

            publishDeleteTravelUseCase.execute(ObtainedTravelDomainToDeleteTravelModelTranslator.translate(obtainedTravelDomain));

        } catch (final Exception e) {

            log.error(String.format("Falha ao remover viagem id: %s. | Erro: %s", id, e));

            throw new TravelException(String.format("Ocorreu um erro ao remover a viagem com id: %s.", id));

        }
    }
}
