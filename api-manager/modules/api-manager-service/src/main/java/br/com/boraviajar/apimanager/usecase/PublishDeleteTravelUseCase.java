package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.exception.PublishDeleteTravelException;
import br.com.boraviajar.apimanager.gateway.PublishDeleteTravelGateway;
import br.com.boraviajar.apimanager.gateway.messaging.model.DeleteTravelModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PublishDeleteTravelUseCase {

    @Autowired
    private PublishDeleteTravelGateway publishDeleteTravelGateway;

    public void execute(final DeleteTravelModel deleteTravelModel) {

        try {

            log.debug("Publicando mensagem no serviço de mensageria. Payload.:{}", deleteTravelModel);

            publishDeleteTravelGateway.publish(deleteTravelModel);

        } catch (final Exception e) {

            log.error(String.format("Falha ao publicar mensagem no serviço de mensageria.: %s . | Erro: %s", deleteTravelModel, e));

            throw new PublishDeleteTravelException(String.format("Ocorreu um erro ao publicar mensagem no serviço de mensageria. %s", deleteTravelModel));

        }
    }
}
