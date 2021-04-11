package com.copersystem.banco.controller;

import com.copersystem.banco.dto.DataDTO;
import com.copersystem.banco.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/bb")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public String cotacao(@ModelAttribute DataDTO dto){
        return apiService.obterCotacao(dto);

    }
}
