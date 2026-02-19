package com.java14_spring_ai_embedding_using_ollama.java14_spring_ai_embedding_using_ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {
    private ChatClient chatClient;
    @Autowired
    private EmbeddingModel embeddingModel;
    ChatMemory chatMemory=MessageWindowChatMemory.builder().build();
    public OllamaController(ChatClient.Builder builder){
        this.chatClient=builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();

    }
    @GetMapping("/api/v1/test")
    public String test_get(){
        return "Ok";
    }
    @PostMapping("/api/v1/response")
    public String get_response(@RequestParam String query){
        PromptTemplate promptTemplate=new PromptTemplate(query);
        String response=chatClient.prompt(promptTemplate.create()).call().content();
        System.out.println(response);
        return response;
    }
    @PostMapping("/api/v1/embedding")
    public float[] get_embedding(@RequestParam String query){
        return embeddingModel.embed(query);
        // return 0.1;
    }
}
