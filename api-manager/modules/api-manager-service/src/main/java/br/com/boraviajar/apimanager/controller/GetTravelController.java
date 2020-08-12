package br.com.boraviajar.apimanager.controller;

import br.com.boraviajar.apimanager.api.GetTravelApi;
import br.com.boraviajar.apimanager.controller.translator.RetrievedTravelDomainToGetTravelResponseTranslator;
import br.com.boraviajar.apimanager.controller.translator.SearchTravelRequestToSearchTravelDomainTranslator;
import br.com.boraviajar.apimanager.domain.travel.SearchTravelDomain;
import br.com.boraviajar.apimanager.model.gettravel.GetTravelResponse;
import br.com.boraviajar.apimanager.model.gettravel.SearchTravelRequest;
import br.com.boraviajar.apimanager.usecase.GetTravelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GetTravelController implements GetTravelApi {

    @Autowired
    private GetTravelUseCase getTravelUseCase;

    @Override
    public ResponseEntity<List<GetTravelResponse>> get(@RequestHeader("agency_id") final String agencyId, @Valid final SearchTravelRequest searchTravelRequest) {

        final SearchTravelDomain searchTravelDomain = SearchTravelRequestToSearchTravelDomainTranslator.translate(agencyId, searchTravelRequest);

        final Page<GetTravelResponse> getTravelResponses = getTravelUseCase.excute(searchTravelDomain)
                .map(RetrievedTravelDomainToGetTravelResponseTranslator::translate);

        final HttpHeaders headers = new HttpHeaders();

        headers.set("x-total-count", String.valueOf(getTravelResponses.getTotalElements()));
        headers.set("x-total-pages", String.valueOf(getTravelResponses.getTotalPages()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(getTravelResponses.getContent());

    }
}
