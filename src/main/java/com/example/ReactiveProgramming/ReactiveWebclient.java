package com.example.ReactiveProgramming;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class ReactiveWebclient {

     private final WebClient webClient;

    public ReactiveWebclient() {
        this.webClient = WebClient.builder()
                .baseUrl("someurl")
                .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE,
                "Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<ReturnedItem> callOne() {
        return webClient.get().uri("wait1").retrieve().bodyToMono(ReturnedItem.class);
    }

    public record ReturnedItem(UUID id, String info) {}
}
