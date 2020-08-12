package br.com.boraviajar.apimanager.gateway.database.translator;

import br.com.boraviajar.apimanager.domain.imagelogo.AddedImageLogoDomain;
import br.com.boraviajar.apimanager.gateway.database.entity.imagelogo.ImageLogoEntity;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class ImageLogoEntityToAddedImageLogoDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static AddedImageLogoDomain translate(final ImageLogoEntity imageLogoEntity) {

        return MAPPER.map(imageLogoEntity, AddedImageLogoDomain.class);

    }

}
