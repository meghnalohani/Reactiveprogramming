package com.example.ReactiveProgramming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveExamplesController {

    private final ReactiveService reactiveService;
    private final ReactiveWebclient reactiveWebclient;

    public ReactiveExamplesController(ReactiveService reactiveService, ReactiveWebclient reactiveWebclient) {
        this.reactiveService = reactiveService;
        this.reactiveWebclient = reactiveWebclient;
    }
    @GetMapping("/defaultStatus")
    public Mono<ReactiveService.ReturnObject> defaultStatus() {
        return reactiveService.simpleCall();
    }
}
