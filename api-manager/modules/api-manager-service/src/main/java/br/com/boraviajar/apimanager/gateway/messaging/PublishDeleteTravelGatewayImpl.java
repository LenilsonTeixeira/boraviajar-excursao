package br.com.boraviajar.apimanager.gateway.messaging;

import br.com.boraviajar.apimanager.gateway.PublishDeleteTravelGateway;
import br.com.boraviajar.apimanager.gateway.messaging.model.DeleteTravelModel;
import br.com.boraviajar.apimanager.gateway.messaging.source.PublishDeleteTravelSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding(PublishDeleteTravelSource.class)
@Service("publishDeleteTravelGatewayImpl")
public class PublishDeleteTravelGatewayImpl implements PublishDeleteTravelGateway {

    @Autowired
    private PublishDeleteTravelSource publishDeleteTravelSource;

    @Override
    public void publish(final DeleteTravelModel deleteTravelModel) {

        publishDeleteTravelSource.messageChannel().send(MessageBuilder.withPayload(deleteTravelModel).build());

    }
}
