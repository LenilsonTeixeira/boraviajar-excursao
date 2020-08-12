package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.imagelogo.AddImageLogoDomain;
import br.com.boraviajar.apimanager.util.ImagePatternUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static java.nio.file.FileSystems.getDefault;

@Slf4j
@Component
public class UploadLocalImageLogoUseCase {

    private Path path;

    public UploadLocalImageLogoUseCase(final @Value("${storage.image.logo.path}") String pathImage){

        this.path = Path.of(pathImage);

    }

    AddImageLogoDomain execute(final String agencyId, final MultipartFile file) throws IOException {

        String fileTemp = path.toAbsolutePath().toString() + getDefault().getSeparator() + ImagePatternUtils.prepareImageName(file.getOriginalFilename());

        file.transferTo(new File(fileTemp));

        return AddImageLogoDomain.builder()
                .agencyId(agencyId)
                .url(fileTemp)
                .dateStorage(LocalDateTime.now())
                .build();

    }
}
