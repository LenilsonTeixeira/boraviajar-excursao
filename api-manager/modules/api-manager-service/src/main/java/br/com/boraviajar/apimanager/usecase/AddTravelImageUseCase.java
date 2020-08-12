package br.com.boraviajar.apimanager.usecase;

import br.com.boraviajar.apimanager.domain.travel.ObtainedTravelDomain;
import br.com.boraviajar.apimanager.domain.travelimage.AddTravelImageDomain;
import br.com.boraviajar.apimanager.domain.travelimage.AddedTravelImageDomain;
import br.com.boraviajar.apimanager.gateway.AddTravelImageGateway;
import br.com.boraviajar.apimanager.usecase.rule.PreCondition;
import br.com.boraviajar.apimanager.usecase.rule.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Slf4j
@Component
public class AddTravelImageUseCase {

    @Autowired
    private AddTravelImageGateway addTravelImageGateway;

    @Autowired
    private GetOneTravelUseCase getOneTravelUseCase;

    @Autowired
    private UploadTravelImageUseCase uploadTravelImageUseCase;

    @Autowired
    private PreCondition preCondition;

    public AddedTravelImageDomain execute(final String travelId, final MultipartFile[] files) {

        for(final Rule<String> preCondition: this.preCondition.get()) {

            preCondition.validate(travelId);

        }

        try{

            final ObtainedTravelDomain obtainedTravelDomain = getOneTravelUseCase.execute(travelId);

            final Collection<AddTravelImageDomain> addTravelImageDomains = uploadTravelImageUseCase.execute(obtainedTravelDomain, files);

            return addTravelImageGateway.upload(null);

        } catch (final Exception e) {

        }

        return null;
    }
}
