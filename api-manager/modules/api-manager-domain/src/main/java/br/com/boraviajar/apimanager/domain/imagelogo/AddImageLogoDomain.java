package br.com.boraviajar.apimanager.domain.imagelogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddImageLogoDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String agencyId;
    private String url;
    private LocalDateTime dateStorage;

}
