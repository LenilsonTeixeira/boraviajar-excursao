package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.updatetravel.UpdateTravelRequest;
import br.com.boraviajar.apimanager.model.updatetravel.UpdateTravelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface UpdateTravelApi {

    @PutMapping("viagens/{id}")
    @ResponseStatus(HttpStatus.OK)
    UpdateTravelResponse update(@RequestHeader("agency_id") final String agencyId,
                                @PathVariable("id") final String id,
                                @Valid @RequestBody final UpdateTravelRequest updateTravelRequest);
}
