package br.com.boraviajar.apimanager.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class ImagePatternUtils {

    public String prepareImageName(final String originalName) {
        return format(originalName);
    }

    private String format(final String name) {
        return UUID.randomUUID()
                .toString()
                .concat("-")
                .concat(name)
                .replaceAll("\\s+", "-")
                .toLowerCase()
                .trim();
    }
}
