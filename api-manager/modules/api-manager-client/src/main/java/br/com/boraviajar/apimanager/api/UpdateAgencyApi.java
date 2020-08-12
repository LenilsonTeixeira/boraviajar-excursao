package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.updateagency.UpdateAgencyRequest;
import br.com.boraviajar.apimanager.model.updateagency.UpdateAgencyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface UpdateAgencyApi {

    @PutMapping("agencias/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    UpdateAgencyResponse update(@RequestHeader("agency_id") final String agencyId,
                                @PathVariable("id") final String id,
                                @Valid @RequestBody final UpdateAgencyRequest updateAgencyRequest);
}
