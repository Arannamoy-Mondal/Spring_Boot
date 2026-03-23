package com.aranna.pactice_10_sse.controller;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {
    @Autowired
    private ChatModel chatModel;

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String, String>> chatStream(@RequestParam String message) {
        return chatModel.stream(new Prompt(message

                , OllamaChatOptions.builder()
                        .model("gpt-oss:latest")
                        .build()))
                .map(response -> {
                    String content = response.getResult().getOutput().getText();
                    return Map.of("text", (content != null) ? content : "");
                    
                });
    }
}
