package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelo.Cancion;

public interface Repositorio extends JpaRepository<Cancion, Long> {
}
