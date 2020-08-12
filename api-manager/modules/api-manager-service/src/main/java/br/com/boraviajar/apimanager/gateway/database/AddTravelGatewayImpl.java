package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.travel.AddTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.AddedTravelDomain;
import br.com.boraviajar.apimanager.gateway.AddTravelGateway;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import br.com.boraviajar.apimanager.gateway.database.repository.TravelRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.AddTravelDomainToTravelEntityTranslator;
import br.com.boraviajar.apimanager.gateway.database.translator.TravelEntityToAddedTravelDomainTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addTravelGatewayImpl")
public class AddTravelGatewayImpl implements AddTravelGateway {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public AddedTravelDomain add(AddTravelDomain addTravelDomain) {

        final TravelEntity travelEntity = AddTravelDomainToTravelEntityTranslator.translate(addTravelDomain);

        travelEntity.generateId();

        return TravelEntityToAddedTravelDomainTranslator.translate(travelRepository.save(travelEntity));
    }
}
