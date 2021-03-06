package com.coopersystem.banco.service;

import com.coopersystem.banco.dto.CotacaoDTO;
import com.coopersystem.banco.dto.ResponseDTO;
import com.coopersystem.banco.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@Service
public class CotacaoService {

    @Autowired
    RestTemplate restTemplate;

    public CotacaoDTO[] obterCotacao(LocalDate data) {
        LocalDate dataAnterior = data.minusDays(1);
        dataAnterior = DateUtils.getUltimoDiaUtil(dataAnterior);
        return apiBB(DateUtils.formatarDataParaUS(dataAnterior), DateUtils.formatarDataParaUS(data));
    }

    public CotacaoDTO[] apiBB(String dataAnterior, String data) {
        String url = "http://api-server:8080//api/bb?dataInicio={dataInicio}&dataFinal={dataFinal}";

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseDTO.class,
                dataAnterior, data);
        return response.getBody().getValue();
    }



}
