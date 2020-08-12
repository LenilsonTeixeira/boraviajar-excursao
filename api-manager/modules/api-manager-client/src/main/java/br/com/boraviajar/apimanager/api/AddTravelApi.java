package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.addtravel.TravelRequest;
import br.com.boraviajar.apimanager.model.addtravel.TravelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface AddTravelApi {

    @PostMapping("viagens")
    @ResponseStatus(value = HttpStatus.CREATED)
    TravelResponse add(@RequestHeader("agency_id") final String agency, @Valid @RequestBody final TravelRequest travelRequest);

}
