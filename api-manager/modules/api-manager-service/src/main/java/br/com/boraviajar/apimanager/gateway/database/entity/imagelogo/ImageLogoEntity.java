package br.com.boraviajar.apimanager.gateway.database.entity.imagelogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "logos")
public class ImageLogoEntity {

    @Id
    private String id;
    private String agencyId;
    private String url;
    private LocalDateTime dateStorage;

    public void generateId() {

        this.setId(String.valueOf(UUID.randomUUID()));

    }
}
