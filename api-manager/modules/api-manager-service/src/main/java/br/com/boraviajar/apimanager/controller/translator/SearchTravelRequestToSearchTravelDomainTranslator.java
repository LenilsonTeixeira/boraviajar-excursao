package br.com.boraviajar.apimanager.controller.translator;

import br.com.boraviajar.apimanager.domain.travel.SearchTravelDomain;
import br.com.boraviajar.apimanager.model.gettravel.SearchTravelRequest;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class SearchTravelRequestToSearchTravelDomainTranslator {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static SearchTravelDomain translate(final String agencyId, final SearchTravelRequest searchTravelRequest) {

        final SearchTravelDomain searchTravelDomain = MAPPER.map(searchTravelRequest, SearchTravelDomain.class);

        searchTravelDomain.setAgencyId(agencyId);

        return searchTravelDomain;

    }
}
