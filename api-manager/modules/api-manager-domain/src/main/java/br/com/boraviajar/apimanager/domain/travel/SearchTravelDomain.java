package br.com.boraviajar.apimanager.domain.travel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTravelDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String agencyId;
    private Integer page;
    private Integer size;
}
