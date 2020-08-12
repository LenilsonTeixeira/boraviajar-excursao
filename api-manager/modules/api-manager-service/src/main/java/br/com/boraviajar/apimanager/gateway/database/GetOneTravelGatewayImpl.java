package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.gateway.GetOneTravelGateway;
import br.com.boraviajar.apimanager.gateway.database.repository.TravelRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.TravelEntityToObtainedTravelDomainTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("getOneTravelGatewayImpl")
public class GetOneTravelGatewayImpl implements GetOneTravelGateway {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public Optional<ObtainedTravelDomain> get(final String id) {

        return travelRepository.findById(id)
                .map(TravelEntityToObtainedTravelDomainTranslator::translate);

    }
}
