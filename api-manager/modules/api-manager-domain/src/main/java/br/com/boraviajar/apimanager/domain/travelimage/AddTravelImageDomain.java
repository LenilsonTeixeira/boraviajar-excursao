package br.com.boraviajar.apimanager.domain.travelimage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTravelImageDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String travelId;
    private String url;
    private LocalDateTime dateStorage;
    private LocalDate limitDateStorage;

}
