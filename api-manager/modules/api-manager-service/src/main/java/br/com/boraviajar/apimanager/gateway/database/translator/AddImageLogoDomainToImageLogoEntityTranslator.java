package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.imagelogo.AddImageLogoDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.imagelogo.ImageLogoEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AddImageLogoDomainToImageLogoEntityTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static ImageLogoEntity translate(final AddImageLogoDomain addImageLogoDomain) {

        return MAPPER.map(addImageLogoDomain, ImageLogoEntity.class);

    }

}
