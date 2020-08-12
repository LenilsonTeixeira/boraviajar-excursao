package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.UpdateTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.UpdatedTravelDomain;
import br.com.boraviajar.apimanager.exception.TravelException;
import br.com.boraviajar.apimanager.gateway.UpdateTravelGateway;
import br.com.boraviajar.apimanager.translator.UpdatedTravelDomainToSaveTravelModelTranslator;
import br.com.boraviajar.apimanager.usecase.rule.Rule;
import br.com.boraviajar.apimanager.usecase.rule.PreCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j
@Component
public class UpdateTravelUseCase {

    @Autowired
    private GetOneTravelUseCase getOneTravelUseCase;

    @Autowired
    private PublishSaveTravelUseCase publishSaveTravelUseCase;

    @Autowired
    private PreCondition preCondition;

    @Autowired
    private UpdateTravelGateway updateTravelGateway;

    public UpdatedTravelDomain execute(final UpdateTravelDomain updateTravelDomain) {

        for(final Rule<String> preCondition: this.preCondition.get()) {

            preCondition.validate(updateTravelDomain.getAgencyId());

        }

        try {

            final ObtainedTravelDomain obtainedTravelDomain = getOneTravelUseCase.execute(updateTravelDomain.getId());

            Assert.notNull(obtainedTravelDomain, "A consulta deve retornar uma Viagem.");

            log.debug("Atualizando viagem id: {}", updateTravelDomain.getId());

            final UpdatedTravelDomain updatedTravelDomain = updateTravelGateway.update(updateTravelDomain);

            publishSaveTravelUseCase.execute(UpdatedTravelDomainToSaveTravelModelTranslator.translate(updatedTravelDomain));

            return updatedTravelDomain;

        } catch (final Exception e) {

            log.error(String.format("Falha ao atualizar viagem: %s. | Erro: %s", updateTravelDomain, e));

            throw new TravelException(String.format("Ocorreu um erro ao atualizar a viagem.  [Destino: %s | Data: %s].", updateTravelDomain.getDestination(), updateTravelDomain.getDepartureDate()));

        }
    }
}
