package br.com.boraviajar.apimanager.gateway;

import br.com.boraviajar.apimanager.gateway.messaging.model.DeleteTravelModel;

public interface PublishDeleteTravelGateway {

    void publish(DeleteTravelModel deleteTravelModel);

}
