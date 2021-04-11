package com.coopersystem.banco.controller;

import com.coopersystem.banco.dto.CotacaoDTO;
import com.coopersystem.banco.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/cotacao")
public class CotacaoController {


    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping
    public CotacaoDTO[] cotacao(@Valid @RequestParam String data){
        return cotacaoService.obterCotacao(dateFormat(data));

    }

    public LocalDate dateFormat(String date) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(date, formato);
        return data;
    }
}
