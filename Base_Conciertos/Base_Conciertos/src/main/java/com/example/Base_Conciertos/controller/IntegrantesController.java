package com.example.Base_Conciertos.controller;

import com.example.Base_Conciertos.entity.Integrante;
import com.example.Base_Conciertos.repository.IntegranteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/integrante")
public class IntegrantesController {
    final IntegranteRepository integranteRepository;
    public IntegrantesController(IntegranteRepository integranteRepository){
        this.integranteRepository = integranteRepository;
    }
    @GetMapping(value = {"", "/"})
    public String index(Model model){
        List<Integrante> integranteList = integranteRepository.findAll();
        model.addAttribute("integranteList", integranteList);
        return "integrante";
    }
    @GetMapping("/integrante/borrar")
    public String borrar(@RequestParam("id") int id){
        Optional<Integrante> optProv =integranteRepository.findById(id);
        if(optProv.isPresent()){
            integranteRepository.deleteById(id);
        }
        return "redirect:/integrante";

    }
}
