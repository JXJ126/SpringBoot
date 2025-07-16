package com.sw.service.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sw.service.domain.entity.Labor;
import com.sw.service.domain.repository.LaborRepository;
import com.sw.service.domain.service.LaborService;
import com.sw.service.rest.mapper.LaborMapper;
import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LaborController.class)
public class LaborControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @MockitoBean
    LaborService mockLaborService;

    @MockitoBean
    LaborRepository mockLaborRepository;

    @MockitoBean
    LaborMapper mockLaborMapper;

    @BeforeEach
    public void setup() throws IOException {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }

    @Test
    void labor_Request_Endpoint_Return_200_When_Request_Is_Valid() throws Exception {
        LaborRequestResource request = new LaborRequestResource(10.0,10.0,2.0);
        this.mockMvc.perform(post("/labor/price")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is(200));
    }

    @Test
    void GIVEN_a_labor_request_WITH_valid_data_a_labor_response_is_returned() throws Exception {
        LaborRequestResource request = new LaborRequestResource(10.0,2.0,10.0);
        Labor labor = new Labor(1,10.0,10.0,2.0,200.0);
        LaborResponseResource response = new LaborResponseResource(200.0,1);

        given(mockLaborMapper.convertLaborRequesttoLabor(any())).willReturn(labor);
        given(mockLaborMapper.convertLabortoLaborResponse(any())).willReturn(response);
        given(mockLaborRepository.save(any())).willReturn(labor);
        given(mockLaborService.saveCost(any())).willReturn(labor);

        this.mockMvc.perform(post("/labor/price")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(response)));
    }

    @Test
    void GIVEN_a_labor_request_WITH_invalid_data_an_error_is_returned() throws Exception {
        LaborRequestResource request = new LaborRequestResource(0.0,0.0,0.0);
        Labor labor = new Labor(1,00.0,00.0,0.0,000.0);

        given(mockLaborMapper.convertLaborRequesttoLabor(any())).willReturn(labor);

        this.mockMvc.perform(post("/labor/price")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError());
    }
}
