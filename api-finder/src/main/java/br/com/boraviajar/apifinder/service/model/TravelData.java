package br.com.boraviajar.apifinder.service.model;

import br.com.boraviajar.apifinder.document.Travel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelData implements Serializable {

    private Long totalElements;
    private String scrollId;

    @Builder.Default
    private List<Travel> elements = new ArrayList<>();
}
