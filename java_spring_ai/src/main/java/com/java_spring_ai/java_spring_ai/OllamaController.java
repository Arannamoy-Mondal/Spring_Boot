package com.java_spring_ai.java_spring_ai;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {
    // private OllamaChatModel chatModel;
    private ChatClient chatClient;
    // public OllamaController(OllamaChatModel chatModel){
    //     this.chatModel=chatModel;
    // }
    public OllamaController(OllamaChatModel chatModel){
        this.chatClient=ChatClient.create(chatModel);
    }
    @GetMapping("/api/{message}")
    public ResponseEntity<String> testOllama(@PathVariable String message){
        // String res=chatModel.call("tell me about java and rust.");
        String res=chatClient.prompt(message).call().content();
        System.out.println(res);
        return ResponseEntity.ok(res);
    }
}
