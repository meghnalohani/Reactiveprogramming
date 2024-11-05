package com.example.ReactiveProgramming;

import reactor.core.publisher.Mono;

import java.util.List;

public class ReactiveService {
    private final ReactiveWebclient reactiveWebClient;

    public ReactiveService(ReactiveWebclient reactiveWebClient) {
        this.reactiveWebClient = reactiveWebClient;
    }

    public Mono<ReturnObject> simpleCall() {
        return reactiveWebClient
                .callOne()
                .map(returnedItem -> {
                    var ids = List.of(returnedItem.id().toString());
                    return new ReturnObject(ids, null);
                });
    }

    public record ReturnObject(List<String> ids, String n) {}
}
