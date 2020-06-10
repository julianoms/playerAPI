package com.playerAPI.utils;

import com.playerAPI.exceptions.PlayerApiException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class FileGetter implements SongGetter{

    // This ephemeral approach contains blocking code.. :/
    @Override
    public InputStreamResource getSong(String id){
        try {
            File songFile = ResourceUtils.getFile(String.format("classpath:mp3/%s.mp3", id));
            return new InputStreamResource(new FileInputStream(songFile));
        } catch (FileNotFoundException e) {
            throw new PlayerApiException("Error while reading the file", e);
        }
    }
}
