package com.example.Base_Conciertos.controller;

import com.example.Base_Conciertos.entity.Concierto;
import com.example.Base_Conciertos.repository.ConciertoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    final ConciertoRepository conciertoRepository;

    public HomeController(ConciertoRepository conciertoRepository){
        this.conciertoRepository = conciertoRepository;
    }
    @GetMapping(value = {"", "/", "index"})
    public String index(Model model){
        List<Concierto> conciertoList = conciertoRepository.findAll();
        model.addAttribute("conciertoList", conciertoList);
        return "index";
    }
}
