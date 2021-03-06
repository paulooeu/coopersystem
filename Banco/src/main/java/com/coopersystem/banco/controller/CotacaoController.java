package com.coopersystem.banco.controller;

import com.coopersystem.banco.dto.CotacaoDTO;
import com.coopersystem.banco.service.CotacaoService;
import com.coopersystem.banco.utils.DateUtils;
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
        return cotacaoService.obterCotacao(DateUtils.formatarDataBrParaLocalDate(data));

    }


}
