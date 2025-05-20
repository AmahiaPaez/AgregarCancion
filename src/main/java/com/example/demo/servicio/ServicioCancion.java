package com.example.demo.servicio;

import com.example.demo.modelo.Cancion;
import com.example.demo.repositorio.Repositorio;
import java.util.List;
import java.time.LocalDateTime;

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
    
    public Cancion actualizarCancion(Cancion cancion) {
    	cancion.setFechaActualizacion(LocalDateTime.now());
    	return cancionRepo.save(cancion);
    }
    
    public Cancion obtenerPorId(Long id) {
        return cancionRepo.findById(id).orElseThrow(() -> new RuntimeException("Canción no encontrada")); //sino esta entonces una excepcion
    }
    
    public void eliminarCancion(Long id) {
        cancionRepo.deleteById(id);
    }


}
