package com.playerAPI.services;

import com.playerAPI.utils.SongGetter;
import com.playerAPI.utils.ValidIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {

    @Autowired
    private SongGetter songGetter;

    public Mono<InputStreamResource> getMusic(String id) {

        if (ValidIds.ids.contains(id)){
            return Mono.just(songGetter.getSong(id));
        }
        return null;
    }
}
