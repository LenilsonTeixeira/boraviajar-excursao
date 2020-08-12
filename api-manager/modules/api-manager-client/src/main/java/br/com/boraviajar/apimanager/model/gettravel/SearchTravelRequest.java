package br.com.boraviajar.apimanager.model.gettravel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTravelRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "O parâmetro page deve ser informado.")
    private Integer page;

    @NotNull(message = "O parâmetro size deve ser informado.")
    private Integer size;

}
