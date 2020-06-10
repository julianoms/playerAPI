package com.playerAPI.services;

import com.playerAPI.utils.SongGetter;
import com.playerAPI.utils.ValidIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
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
