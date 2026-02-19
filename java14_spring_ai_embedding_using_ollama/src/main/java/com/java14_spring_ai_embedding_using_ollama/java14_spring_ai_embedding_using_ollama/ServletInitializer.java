package com.java14_spring_ai_embedding_using_ollama.java14_spring_ai_embedding_using_ollama;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Java14SpringAiEmbeddingUsingOllamaApplication.class);
	}

}
