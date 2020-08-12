package br.com.boraviajar.apimanager.gateway.messaging.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PublishSaveTravelSource {

    @Output("travel")
    MessageChannel messageChannel();

}
