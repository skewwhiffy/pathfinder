package com.example.ping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@WebMvcTest
class PingApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void canPingService() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/ping");
		MvcResult result = mockMvc.perform(request).andReturn();

		System.out.println(result);
	}

}
