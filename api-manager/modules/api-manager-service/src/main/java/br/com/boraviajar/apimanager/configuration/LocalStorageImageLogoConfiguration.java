package br.com.boraviajar.apimanager.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.FileSystems.getDefault;

@Configuration
public class LocalStorageImageLogoConfiguration {

    @Bean
    public Path createDirectoryFromStorageLocalLogo(@Value("${storage.image.logo.path}") final String path) throws IOException {

       return Files.createDirectories(getDefault().getPath(path));

    }
}
