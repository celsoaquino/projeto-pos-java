package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.Quantidade;
import com.celsoaquino.backend.service.VagaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = VagaController.class)
@AutoConfigureMockMvc
public class VagaControllerTest {

    static String VAGA_API = "/vagas";

    @Autowired
    MockMvc mvc;

    @MockBean
    VagaService service;

    @Test
    @DisplayName("Deve criar uma vaga com sucesso.")
    public void createVagaTest() throws Exception {

        Quantidade quantidade = Quantidade.builder().quantidade(1).build();
        String json = new ObjectMapper().writeValueAsString(quantidade);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(VAGA_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        mvc
                .perform(requestBuilder)
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Deve deletar uma vaga.")
    public void deleteVagaTest() throws Exception {

        //BDDMockito.given(service.getVagaById(anyLong())).willReturn(Vaga.builder().id(1L).build());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(VAGA_API.concat("/" + 1));
        mvc
                .perform(requestBuilder)
                .andExpect(status().isNoContent());
    }

}
