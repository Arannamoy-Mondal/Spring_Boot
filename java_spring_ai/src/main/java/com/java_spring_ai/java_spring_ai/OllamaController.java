package com.java_spring_ai.java_spring_ai;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {
    // private OllamaChatModel chatModel;
    private ChatClient chatClient;
    // public OllamaController(OllamaChatModel chatModel){
    //     this.chatModel=chatModel;
    // }
    // public OllamaController(OllamaChatModel chatModel){
    //     this.chatClient=ChatClient.create(chatModel);
    // }
    ChatMemory chatMemory=MessageWindowChatMemory.builder().build();
    public OllamaController(ChatClient.Builder builder){
        this.chatClient=builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build() ;
    }
    @GetMapping("/api/{message}")
    public ResponseEntity<String> testOllama(@PathVariable String message){
        // String res=chatModel.call("tell me about java and rust.");
        ChatResponse res=chatClient.prompt(message).call().chatResponse();
        System.out.println(res);
        String response=res.getResult().getOutput().getText();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/post")
    public String get_result(@RequestParam String type,@RequestParam String year,@RequestParam String lang){
        String temp;
        if (lang!=null){
            temp="""
                You are an expert ai assistant. Now response answer based on question in 1 line.
                Explain me about {type}, year {year} in language {lang}.
                """;
        }
        else{
            temp="""
                You are an expert ai assistant. Now response answer based on question in 1 line.
                Explain me about {type}, year {year} in language english.
                """;
        }
        PromptTemplate promptTemplate=new PromptTemplate(temp);
        Prompt prompt=promptTemplate.create(Map.of("type",type,"year",year,"lang",lang));
        String response=chatClient.prompt(prompt)
        .call().content();
        System.out.println(response);
        return response;
    }
}
