package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.exception.TravelNotFoundException;
import br.com.boraviajar.apimanager.gateway.GetOneTravelGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetOneTravelUseCase {

    @Autowired
    private GetOneTravelGateway getOneTravelGateway;

    public ObtainedTravelDomain execute(final String id) {

        log.debug("Consultando viagem com id: {}", id);

        return getOneTravelGateway.get(id)
                .orElseThrow(() -> new TravelNotFoundException(String.format("Viagem id: %s não encontrada.", id)));

    }

}
