package br.com.boraviajar.apimanager.util;

import br.com.boraviajar.apimanager.exception.FileStorageException;
import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

@UtilityClass
public class ImageValidator {

    public static void isEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileStorageException("Não há nenhum arquivo de imagem carregado para upload. ");
        }
    }
}
