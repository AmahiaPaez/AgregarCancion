package com.example.demo.controlador;

import com.example.demo.modelo.Cancion;
import com.example.demo.servicio.ServicioCancion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/canciones")
public class Controlador {

    @Autowired
    private ServicioCancion cancionService;

    @GetMapping
    public String listarCanciones(Model model) {
        model.addAttribute("listaCanciones", cancionService.obtenerTodas());
        return "canciones";
    }

    @GetMapping("/formulario/agregar/{idCancion}")
    public String formularioAgregarCancion(@PathVariable("idCancion") Long id, Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion";
    }

    @PostMapping("/procesa/agregar")
    public String procesarAgregarCancion(@ModelAttribute("cancion") @Valid Cancion cancion, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "agregarCancion";
        }
        cancionService.agregarCancion(cancion);
        return "redirect:/canciones";
    }
}

