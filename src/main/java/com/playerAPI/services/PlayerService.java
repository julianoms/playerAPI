package com.playerAPI.services;

import com.playerAPI.utils.SongGetter;
import com.playerAPI.utils.ValidIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class PlayerService {

    @Autowired
    private SongGetter songGetter;

    public Mono<byte[]> getMusic(String id) throws IOException {

        if (ValidIds.ids.contains(id)) {
            return Mono.just(songGetter.getSong(id));
        }
        return null;
    }
}
