package br.com.boraviajar.apimanager.api;

import br.com.boraviajar.apimanager.model.addagency.AgencyRequest;
import br.com.boraviajar.apimanager.model.addagency.AgencyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface AddAgencyApi {

    @PostMapping("agencias")
    @ResponseStatus(value = HttpStatus.CREATED)
    AgencyResponse add(@Valid @RequestBody final AgencyRequest agencyRequest);

}
