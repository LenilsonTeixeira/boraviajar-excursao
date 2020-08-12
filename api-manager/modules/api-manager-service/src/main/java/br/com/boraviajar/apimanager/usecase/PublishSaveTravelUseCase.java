package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.gateway.messaging.model.SaveTravelModel;
import br.com.boraviajar.apimanager.exception.PublishSaveTravelException;
import br.com.boraviajar.apimanager.gateway.PublishSaveTravelGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PublishSaveTravelUseCase {

    @Autowired
    private PublishSaveTravelGateway publishSaveTravelGateway;

    public void execute(final SaveTravelModel saveTravelModel) {

        try {

            log.debug("Publicando mensagem no serviço de mensageria. Payload.:{}", saveTravelModel);

            publishSaveTravelGateway.publish(saveTravelModel);

        } catch (final Exception e) {

            log.error(String.format("Falha ao publicar mensagem no serviço de mensageria.: %s . | Erro: %s", saveTravelModel, e));

            throw new PublishSaveTravelException(String.format("Ocorreu um erro ao publicar mensagem no serviço de mensageria. %s", saveTravelModel));
        }

    }
}
