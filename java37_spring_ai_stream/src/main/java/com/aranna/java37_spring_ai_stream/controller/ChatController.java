package com.aranna.java37_spring_ai_stream.controller;


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
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatModel chatModel;
    @GetMapping(value = "/answer",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String,String>> getAnswer(@RequestParam String query){
        return chatModel.stream(
            new Prompt(query,
                OllamaChatOptions.builder()
                .model("gpt-oss:latest")
                .build()
            )
        )
        .map(res->{
            String content=res.getResult().getOutput().getText();
           return Map.of("text",(content!=null)?content:"");
        });
    }
}
