package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.AddTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.AddedTravelDomain;
import br.com.boraviajar.apimanager.exception.TravelException;
import br.com.boraviajar.apimanager.gateway.AddTravelGateway;
import br.com.boraviajar.apimanager.translator.AddedTravelDomainToSaveTravelModelTranslator;
import br.com.boraviajar.apimanager.usecase.rule.PreCondition;
import br.com.boraviajar.apimanager.usecase.rule.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddTravelUseCase {

    @Autowired
    private PublishSaveTravelUseCase publishSaveTravelUseCase;

    @Autowired
    private PreCondition preCondition;

    @Autowired
    private AddTravelGateway addTravelGateway;

    public AddedTravelDomain execute(final AddTravelDomain addTravelDomain){

        for(final Rule<String> preCondition: this.preCondition.get()) {

            preCondition.validate(addTravelDomain.getAgencyId());

        }

        try {

            log.debug("Cadastrando viagem: {}", addTravelDomain);

            final AddedTravelDomain addedTravelDomain = addTravelGateway.add(addTravelDomain);

            publishSaveTravelUseCase.execute(AddedTravelDomainToSaveTravelModelTranslator.translate(addedTravelDomain));

            return addedTravelDomain;

        }catch (final Exception e){

            log.error(String.format("Falha ao salvar viagem.: %s", e));

            throw new TravelException(String.format("Ocorreu um erro ao salvar a viagem.  [Destino: %s | Data: %s].", addTravelDomain.getDestination(), addTravelDomain.getDepartureDate()));
        }
    }

}
