package com.celsoaquino.backend.controller;


import com.celsoaquino.backend.service.MovimentoVagaService;
import com.celsoaquino.backend.service.VagaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = MovimentoVagaController.class)
@AutoConfigureMockMvc
public class MovimentoVagaControllerTest {

    static String VAGA_API = "/movimento";

    @Autowired
    MockMvc mvc;

    @MockBean
    MovimentoVagaService service;

    @Test
    @DisplayName("Deve criar uma movimento com sucesso.")
    public void createMovimentoTest() throws Exception {

    }



}
