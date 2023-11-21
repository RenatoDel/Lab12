package com.example.Base_Conciertos.controller;

import com.example.Base_Conciertos.entity.Proveedor;
import com.example.Base_Conciertos.repository.ProveedorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProveedoresController {
    final ProveedorRepository proveedorRepository;
    public ProveedoresController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping("/proveedor")
    public String listaProveedor(Model model){
        List<Proveedor> lista =proveedorRepository.findAll();
        model.addAttribute("listaProveedor", lista);
        return "proveedor";
    }
    @GetMapping("/proveedor/borrar")
    public String borrar(@RequestParam("id") int id){
        Optional<Proveedor> optProv =proveedorRepository.findById(id);
        if(optProv.isPresent()){
            proveedorRepository.deleteById(id);
        }
        return "redirect:/proveedor";

    }

    @GetMapping("proveedor/editar")
    public String editar(Model model,
                         @RequestParam("id") int id){
        Optional<Proveedor> optProv = proveedorRepository.findById(id);
        if(optProv.isPresent()){
            Proveedor prov = optProv.get();
            model.addAttribute("prov", prov);
            return "proveedorForm";
        }
        return "redirect:/proveedor";
    }
    @GetMapping(value="/proveedor/nuevo")
    public String nuevaProveedor(){
        return "proveedorNuevo";
    }

    @PostMapping(value = "proveedor/guardar")
    public String guardarProveedor(Proveedor proveedor){
        proveedorRepository.save(proveedor);
        return "redirect:/proveedor";
    }
}
