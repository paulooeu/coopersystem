package com.coopersystem.banco.service;

import com.coopersystem.banco.dto.CotacaoDTO;
import com.coopersystem.banco.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CotacaoService {

    @Autowired
    RestTemplate restTemplate;

    public CotacaoDTO[] obterCotacao(LocalDate data){


        LocalDate dataAnterior = data.minusDays(1);
        dataAnterior = getDiaUtil(dataAnterior);


        return  apiBB(dateFormat(dataAnterior),dateFormat(data));
    }

    public CotacaoDTO[] apiBB(String dataAnterior, String data){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ResponseDTO> response = restTemplate.exchange("http://api-server:8080//api/bb?dataInicio={dataInicio}&dataFinal={dataFinal}",
                HttpMethod.GET,
                entity,
                ResponseDTO.class,
                dataAnterior,
                data,
                "json"
        );
        return response.getBody().getValue();

    }

    private String dateFormat(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String retorno = localDate.format(formatter);
        return retorno;
    }
    private boolean dataValida(LocalDate date) {
        if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
            return true;
        }
        return false;
    }


    private LocalDate getDiaUtil(LocalDate date) {
        boolean x = true;

        while (x) {
            if (dataValida(date)) {
                x = false;
            } else {
                date = date.minusDays(1);

            }
        }
        return date;
    }

}
