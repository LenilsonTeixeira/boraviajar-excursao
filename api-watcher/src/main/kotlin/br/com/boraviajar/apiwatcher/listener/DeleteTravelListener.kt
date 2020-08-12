package br.com.boraviajar.apiwatcher.listener

import br.com.boraviajar.apiwatcher.exception.ProcessStreamException
import br.com.boraviajar.apiwatcher.listener.model.Travel
import br.com.boraviajar.apiwatcher.listener.sink.DeleteTravelSink
import br.com.boraviajar.apiwatcher.service.TravelService
import mu.KotlinLogging
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener

@EnableBinding(DeleteTravelSink::class)
class DeleteTravelListener(val travelService: TravelService) {

    private val logger = KotlinLogging.logger {};

    @StreamListener(target = "delete-travel")
    fun consumeMessage(travel: Travel) {
        try {
            logger.debug { "Mensagem consumida com sucesso.: [Payload: ${travel}]" };
            travelService.deleteById(travel.id);
        } catch (e: Exception){
            logger.error { "Falha no processamento de mensagem." };
            throw ProcessStreamException("Falha durante processamento de stream. ${e.message}");
        }
    }
}