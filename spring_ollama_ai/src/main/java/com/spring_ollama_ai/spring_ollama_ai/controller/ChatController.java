package com.spring_ollama_ai.spring_ollama_ai.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ChatController {
    @Autowired
    private ChatModel chatModel;

    @PostMapping("/chat")
    public ResponseEntity<?> postMethodName(@RequestBody String entity) {
        try {
            ChatResponse response = chatModel.call(
                new Prompt(
                        entity,
                        OllamaChatOptions.builder()
                                .model("phi4:latest")
                                // .enableThinking()
                                .build()));

        String thinking = response.getResult().getMetadata().get("thinking");
        String answer = response.getResult().getOutput().getText();
        return ResponseEntity.status(HttpStatus.OK).body("Thinking:\n"+thinking+"\n🏅🏅🏅🏅🏅🏅🏅🏅🏅🏅🏅\nAnswer:\n"+answer);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }

}
