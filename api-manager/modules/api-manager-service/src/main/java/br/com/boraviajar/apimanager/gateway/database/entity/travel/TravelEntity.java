package br.com.boraviajar.apimanager.gateway.database.entity.travel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "travels")
public class TravelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String destination;

    private String description;

    private String departureCity;

    private LocalDate departureDate;

    private LocalDate returnDate;

    private LocalTime departureTime;

    private LocalTime returnTime;

    private BigDecimal price;

    private String agencyId;

//    private List<ImageTravel> images;

    @CreatedDate
    private LocalDateTime createdDate;

    private LocalDateTime expiresIn;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public void generateId() {

        this.setId(String.valueOf(UUID.randomUUID()));

    }
}
