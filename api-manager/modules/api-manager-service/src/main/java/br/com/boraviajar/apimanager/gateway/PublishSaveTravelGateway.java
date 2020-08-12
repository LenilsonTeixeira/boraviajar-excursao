package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.gateway.messaging.model.SaveTravelModel;

public interface PublishSaveTravelGateway {

    void publish(SaveTravelModel saveTravelModel);

}
