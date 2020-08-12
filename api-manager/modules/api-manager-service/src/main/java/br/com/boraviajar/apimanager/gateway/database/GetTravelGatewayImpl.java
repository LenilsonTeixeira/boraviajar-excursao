package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.travel.RetrievedTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.SearchTravelDomain;
import br.com.boraviajar.apimanager.gateway.GetTravelGateway;
import br.com.boraviajar.apimanager.gateway.database.repository.TravelRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.TravelEntityToRetrievedTravelDomainTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service("getTravelGatewayImpl")
public class GetTravelGatewayImpl implements GetTravelGateway {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public Page<RetrievedTravelDomain> get(SearchTravelDomain searchTravelDomain) {

        return this.travelRepository.findByAgencyId(searchTravelDomain.getAgencyId(),
                PageRequest.of(searchTravelDomain.getPage(), searchTravelDomain.getSize()))
                .map(TravelEntityToRetrievedTravelDomainTranslator::translate);

    }
}
