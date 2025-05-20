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
    private ServicioCancion cancionServicio;

    @GetMapping
    public String listarCanciones(Model model) {
        model.addAttribute("listaCanciones", cancionServicio.obtenerTodas());
        return "canciones"; 
    }

    @GetMapping("/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion"; 
    }

    @PostMapping("/procesa/agregar")
    public String procesarAgregarCancion(@ModelAttribute("cancion") @Valid Cancion cancion, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "agregarCancion";
        }
        cancionServicio.agregarCancion(cancion);
        return "redirect:/canciones";
    }


    @GetMapping("/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = cancionServicio.obtenerPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("cancion", cancion);
            return "editar"; 
        }
        return "redirect:/canciones";
    }

    @PostMapping("/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,  @ModelAttribute("cancion") @Valid Cancion cancion, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "editar";
        }
        cancion.setId(idCancion);
        cancionServicio.actualizarCancion(cancion);
        return "redirect:/canciones";
    }
    
    @DeleteMapping("/procesa/eliminar/{id}")
    public String eliminarCancion(@PathVariable Long id) {
        cancionServicio.eliminarCancion(id);
        return "redirect:/canciones";
    }


}

 