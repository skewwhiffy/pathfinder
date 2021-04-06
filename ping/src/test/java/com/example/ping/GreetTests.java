package com.example.ping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@WebMvcTest
class GreetTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void canGetGreeting() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/greet")
                // TODO: Do you understand what JSON is?
                .content("{ \"name\": \"Mr Smith\" }")
                .contentType(MediaType.APPLICATION_JSON);
        MockHttpServletResponse result = mockMvc.perform(request).andReturn().getResponse();
        assertThat(result.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(result.getContentAsString()).isEqualTo("Hello Mr Smith");
    }
}
