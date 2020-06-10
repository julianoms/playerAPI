package com.playerAPI.controllers;

import com.playerAPI.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class PlayerController {
    @Autowired
    PlayerService service;

    @GetMapping("/music/{id}")
    public Mono<ResponseEntity<InputStreamResource>> listenMusic(@PathVariable(name = "id") String id) throws IOException {
        return service.getMusic(id)
                .map(resp -> ResponseEntity.ok()
                        .contentLength(resp.length)
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + id + "\"")
                        .body(new InputStreamResource(new ByteArrayInputStream(resp))))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
