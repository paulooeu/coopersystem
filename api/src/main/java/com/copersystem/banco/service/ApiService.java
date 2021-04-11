package com.copersystem.banco.service;

import com.copersystem.banco.dto.DataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {

    @Autowired
    RestTemplate restTemplate;

    public String obterCotacao(DataDTO dto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange("https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)?@dataInicial='{dataInicio}'&@dataFinalCotacao='{dataFinalCotacao}'&$format={format}",
                HttpMethod.GET,
                entity,
                String.class,
                dto.getDataInicio(),
                dto.getDataFinal(),
                "json"
        );
        return response.getBody();


    }


}
