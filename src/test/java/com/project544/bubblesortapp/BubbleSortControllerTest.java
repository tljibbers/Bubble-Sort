package com.project544.bubblesortapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project544.bubblesortapp.model.NumbersResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BubbleSortControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testSortArray() throws Exception {
       String json="{\"numbers\": [9,8,3,2]}";
       MvcResult result=mockMvc.perform(post("/api/bubblesort/sort")
               .contentType(MediaType.APPLICATION_JSON)
               .content(json))
               .andExpect(status().isOk())
               .andReturn();
       String body = result.getResponse().getContentAsString();
       NumbersResponse numbersResponse =mapper.readValue(body,NumbersResponse.class);
       assertEquals("start-of-pass", numbersResponse.getSteps().getFirst().getStepType(), "First Step Type");

    }
}
