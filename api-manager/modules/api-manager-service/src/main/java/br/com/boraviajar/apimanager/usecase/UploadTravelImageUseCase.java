package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.domain.travelimage.AddTravelImageDomain;
import br.com.boraviajar.apimanager.util.ImagePatternUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static java.nio.file.FileSystems.getDefault;

@Slf4j
@Component
public class UploadTravelImageUseCase {

    private Path path;
    private Collection<AddTravelImageDomain> travelImages;

    @Autowired
    private GetTravelUseCase getTravelUseCase;

    public UploadTravelImageUseCase(final @Value("${storage.travel.image.path}") String pathImage){

        this.path = Path.of(pathImage);

        this.travelImages = new ArrayList<>();

    }

    Collection<AddTravelImageDomain> execute(final ObtainedTravelDomain obtainedTravelDomain, final MultipartFile[] files) throws IOException {

        for(MultipartFile file : files) {

            String fileTemp = path.toAbsolutePath().toString() + getDefault().getSeparator() + ImagePatternUtils.prepareImageName(file.getOriginalFilename());

            file.transferTo(new File(fileTemp));

            travelImages.add(AddTravelImageDomain.builder()
                    .travelId(obtainedTravelDomain.getId())
                    .url(fileTemp)
                    .dateStorage(LocalDateTime.now())
                    .limitDateStorage(obtainedTravelDomain.getReturnDate().plusWeeks(2l))
                    .build());

        }

        return travelImages;

    }
}
