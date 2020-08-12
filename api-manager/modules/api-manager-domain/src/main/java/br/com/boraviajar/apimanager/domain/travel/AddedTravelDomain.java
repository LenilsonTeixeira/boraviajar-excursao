package br.com.boraviajar.apimanager.domain.travel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddedTravelDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String agencyId;
    private String destination;
    private String departureCity;
    private String description;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private LocalTime departureTime;
    private LocalTime returnTime;
    private BigDecimal price;
}
