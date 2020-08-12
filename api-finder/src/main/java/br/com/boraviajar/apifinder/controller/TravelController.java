package br.com.boraviajar.apifinder.controller;

import br.com.boraviajar.apifinder.controller.model.SearchRequestParam;
import br.com.boraviajar.apifinder.document.Travel;
import br.com.boraviajar.apifinder.service.TravelService;
import br.com.boraviajar.apifinder.service.model.TravelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/viagens")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public ResponseEntity<List<Travel>> getTravels(@RequestParam(name = "cidadeOrigem", required = true) final String departureCity,
                                                   @RequestParam(name = "destino", required = false) final String destination,
                                                   @RequestParam(name = "agencia", required = false) final String agency,
                                                   @RequestParam(name = "dataPartida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate departureDate,
                                                   @RequestParam(name = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
                                                   @RequestParam(name = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate){

        final SearchRequestParam searchRequestParam = SearchRequestParam.builder()
                .departureCity(departureCity)
                .destination(destination)
                .agency(agency)
                .departureDate(departureDate)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        final TravelData response = travelService.searchBy(searchRequestParam);

        final HttpHeaders headers = new HttpHeaders();
        headers.set("x-total-count", String.valueOf(response.getTotalElements()));
        headers.set("scrollId", response.getScrollId());

        return ResponseEntity.ok()
                .headers(headers)
                .body(response.getElements());
    }
}
