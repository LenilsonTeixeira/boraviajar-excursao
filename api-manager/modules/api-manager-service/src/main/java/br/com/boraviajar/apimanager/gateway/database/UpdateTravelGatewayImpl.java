package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.domain.travel.UpdateTravelDomain;
import br.com.boraviajar.apimanager.domain.travel.UpdatedTravelDomain;
import br.com.boraviajar.apimanager.gateway.UpdateTravelGateway;
import br.com.boraviajar.apimanager.gateway.database.entity.travel.TravelEntity;
import br.com.boraviajar.apimanager.gateway.database.repository.TravelRepository;
import br.com.boraviajar.apimanager.gateway.database.translator.TravelEntityToUpdatedTravelDomainTranslator;
import br.com.boraviajar.apimanager.gateway.database.translator.UpdateTravelDomainToTravelEntityTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("updateTravelGatewayImpl")
public class UpdateTravelGatewayImpl implements UpdateTravelGateway {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public UpdatedTravelDomain update(UpdateTravelDomain updateTravelDomain) {

        final TravelEntity travelEntity = UpdateTravelDomainToTravelEntityTranslator.translate(updateTravelDomain);

        return TravelEntityToUpdatedTravelDomainTranslator.translate(travelRepository.save(travelEntity));
    }
}
