package br.com.boraviajar.apimanager.usecase.rule;

import br.com.boraviajar.apimanager.exception.AgencyNotFoundException;
import br.com.boraviajar.apimanager.usecase.AgencyExistsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("agencyExistsRule")
public class AgencyExistsRule implements Rule<String>{

    private static final String ERROR_MESSAGE = "Agência não encontrada. [ID: %s]";

    @Autowired
    AgencyExistsUseCase agencyExistsUseCase;

    @Override
    public void validate(String id) {

        if(!agencyExistsUseCase.execute(id)){

            throw new AgencyNotFoundException(String.format(ERROR_MESSAGE, id));

        }
    }
}
