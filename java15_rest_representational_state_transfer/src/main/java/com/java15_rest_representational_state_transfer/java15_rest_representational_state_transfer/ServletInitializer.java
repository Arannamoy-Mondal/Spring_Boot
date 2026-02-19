package com.java15_rest_representational_state_transfer.java15_rest_representational_state_transfer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Java15RestRepresentationalStateTransferApplication.class);
	}

}
