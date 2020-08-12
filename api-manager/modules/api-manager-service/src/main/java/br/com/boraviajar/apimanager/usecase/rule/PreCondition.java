package br.com.boraviajar.apimanager.usecase.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PreCondition {

    private final List<Rule<String>> rules;

    @Autowired
    public PreCondition(
            @Qualifier("agencyExistsRule")
            final Rule<String> agencyExistsRule
    ) {
        this.rules = List.of(agencyExistsRule);
    }

    public List<Rule<String>> get() {
        return this.rules;
    }
}
