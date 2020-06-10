package com.playerAPI.controllers;

import com.playerAPI.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PlayerController {
    @Autowired
    PlayerService service;

    @GetMapping("/music/{id}")
    public Mono<ResponseEntity<InputStreamResource>> listenMusic(@PathVariable(name = "id") String id) {

        System.out.println("bateu");
        return service.getMusic(id)
                .map(response -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachement: filename=\"" + id + "\"")
                        .body(response))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
