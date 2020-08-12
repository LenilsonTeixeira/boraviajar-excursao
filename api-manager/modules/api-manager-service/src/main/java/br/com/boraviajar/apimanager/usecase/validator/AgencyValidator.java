package br.com.boraviajar.apimanager.usecase.validator;

import br.com.boraviajar.apimanager.exception.AgencyValidatorException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AgencyValidator {

    public static void isEquals(final String agencyId, final String id) {

        if (!agencyId.equals(id)) {

            throw new AgencyValidatorException("Operação não permitida por restrição de permissão.");

        }
    }
}
