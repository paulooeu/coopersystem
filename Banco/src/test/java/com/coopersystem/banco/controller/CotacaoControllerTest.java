package com.coopersystem.banco.controller;

import com.coopersystem.banco.dto.CotacaoDTO;
import com.coopersystem.banco.service.CotacaoService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class CotacaoControllerTest {

	private MockMvc mockMvc;

	private LocalDate dataAtual;
	private String data;

	private CotacaoDTO[] cotacaoDTO = new CotacaoDTO[2];

	@Mock
	private CotacaoService cotacaoService;

	@InjectMocks
	CotacaoController cotacaoController;

	@Before
	public void setUp() throws Exception {
		dataAtual = LocalDate.of(2021, Month.APRIL, 6);
		data = "06/04/2021";
		mockMvc = MockMvcBuilders.standaloneSetup(cotacaoController).build();
	}

	@Test
	public void testApi() throws Exception {
		when(cotacaoService.obterCotacao(dataAtual)).thenReturn(cotacaoDTO);
		mockMvc.perform(get("/api/cotacao").param("data", data)).andExpect(status().isOk());
		verify(cotacaoService).obterCotacao(dataAtual);
	}

}
