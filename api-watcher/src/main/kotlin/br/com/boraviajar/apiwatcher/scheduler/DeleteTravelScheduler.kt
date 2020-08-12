package br.com.boraviajar.apiwatcher.scheduler

import br.com.boraviajar.apiwatcher.service.TravelService
import mu.KotlinLogging
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@EnableScheduling
@Component
class DeleteTravelScheduler(val travelService: TravelService) {

    private val logger = KotlinLogging.logger {};

    @Scheduled(cron = "0 0 03 * * *", zone = "America/Sao_Paulo")
    fun deleteTravelsByDateTask(){
        logger.info { "Inicializando processo agenado de exclusão de registros de viagem" };
        travelService.deleteTravelsByDate(LocalDate.now().minusWeeks(2L));
    }
}