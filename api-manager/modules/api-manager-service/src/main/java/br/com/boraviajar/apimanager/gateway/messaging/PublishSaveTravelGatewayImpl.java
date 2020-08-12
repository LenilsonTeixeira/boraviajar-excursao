package br.com.boraviajar.apimanager.gateway.messaging;

import br.com.boraviajar.apimanager.gateway.messaging.model.SaveTravelModel;
import br.com.boraviajar.apimanager.gateway.PublishSaveTravelGateway;
import br.com.boraviajar.apimanager.gateway.messaging.source.PublishSaveTravelSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding(PublishSaveTravelSource.class)
@Service("publishSaveTravelGatewayImpl")
public class PublishSaveTravelGatewayImpl implements PublishSaveTravelGateway {

    @Autowired
    private PublishSaveTravelSource publishSaveTravelSource;

    @Override
    public void publish(SaveTravelModel saveTravelModel) {

        publishSaveTravelSource.messageChannel().send(MessageBuilder.withPayload(saveTravelModel).build());

    }
}
