package br.com.boraviajar.apimanager.gateway.database;

import br.com.boraviajar.apimanager.gateway.DeleteTravelGateway;
import br.com.boraviajar.apimanager.gateway.database.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deleteTravelGatewayImpl")
public class DeleteTravelGatewayImpl implements DeleteTravelGateway {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public void delete(String id) {

        this.travelRepository.deleteById(id);

    }
}
