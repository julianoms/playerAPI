package com.playerAPI.utils;

import com.playerAPI.exceptions.PlayerApiException;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

@Component
public class FileGetter implements SongGetter {

    // This ephemeral approach contains blocking code.. :/
    @Override
    public byte[] getSong(String id) {
        try {
            File songFile = ResourceUtils.getFile(String.format("classpath:mp3/%s.mp3", id));
            return Files.readAllBytes(songFile.toPath());
        } catch (Exception e) {
            throw new PlayerApiException("Error while reading the file", e);
        }
    }
}
