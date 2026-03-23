package com.aranna.java36_spring_websocket;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;

@SpringBootTest
class Java36SpringWebsocketApplicationTests {

	@Autowired
	private ChatModel chatModel;

	@Test
	void contextLoads() {
	}

	@Test
	void getAnswer(){
	ChatResponse chatResponse=chatModel.call(
	new Prompt("Why spring is king in microservices why not others?",
	OllamaChatOptions.builder()
	.model("gpt-oss:latest")
	.build()
	)
	);

	System.out.println(chatResponse.getResult().getOutput().getText());
	}

	// @Test
	// void getAnswerStream() {
	// 	Flux<ChatResponse> stream = chatModel.stream(
	// 			new Prompt(
	// 					"Explain quantum entanglement",
	// 					OllamaChatOptions.builder()
	// 							.model("qwen3")
	// 							.enableThinking()
	// 							.build()));

	// 	stream.doOnNext(response -> {
	// 		String thinking = response.getResult().getMetadata().get("thinking");
	// 		String content = response.getResult().getOutput().getText();

	// 		if (thinking != null && !thinking.isEmpty()) {
	// 			System.out.println("[Thinking] " + thinking);
	// 		}
	// 		if (content != null && !content.isEmpty()) {
	// 			System.out.println("[Response] " + content);
	// 		}
	// 	});
	// }
}
