package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.gettravel.GetTravelResponse;
import br.com.boraviajar.apimanager.model.gettravel.SearchTravelRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface GetTravelApi {

    @GetMapping("viagens")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<GetTravelResponse>> get(@RequestHeader("agency_id") final String agencyId,
                                                @Valid final SearchTravelRequest searchTravelRequest);
}
