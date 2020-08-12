package br.com.boraviajar.apimanager.domain.imagelogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddedImageLogoDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;

}
