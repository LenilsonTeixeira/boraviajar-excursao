package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.RetrievedTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.SearchTravelDomain;
import br.com.boraviajar.apimanager.gateway.GetTravelGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetTravelUseCase {

    @Autowired
    private GetTravelGateway getTravelGateway;

    public Page<RetrievedTravelDomain> excute(final SearchTravelDomain searchTravelDomain){

        log.debug("Recuperando viagens referente a agência ID: {} ", searchTravelDomain.getAgencyId());

        return getTravelGateway.get(searchTravelDomain);

    }

}
