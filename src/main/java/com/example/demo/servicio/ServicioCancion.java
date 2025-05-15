package com.example.demo.servicio;

import com.example.demo.modelo.Cancion;
import com.example.demo.repositorio.Repositorio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCancion{

    @Autowired
    private Repositorio cancionRepo;

    public Cancion agregarCancion(Cancion cancion) {
        return cancionRepo.save(cancion);
    }

    public List<Cancion> obtenerTodas() {
        return cancionRepo.findAll();
    }
}
