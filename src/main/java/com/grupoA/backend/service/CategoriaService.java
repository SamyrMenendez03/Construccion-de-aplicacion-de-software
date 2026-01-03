package com.grupoA.backend.service;

import com.grupoA.backend.model.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
}
