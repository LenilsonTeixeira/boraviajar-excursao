package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.agency.AddedAgencyDomain;
import br.com.boraviajar.apimanager.domain.imagelogo.AddedImageLogoDomain;
import br.com.boraviajar.apimanager.model.addagency.AgencyResponse;
import br.com.boraviajar.apimanager.model.addimagelogo.AddImageLogoResponse;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddedImageLogoDomainToAddImageLogoResponseTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AddImageLogoResponse translate(final AddedImageLogoDomain addedImageLogoDomain) {
        return MAPPER.map(addedImageLogoDomain, AddImageLogoResponse.class);
    }

}
