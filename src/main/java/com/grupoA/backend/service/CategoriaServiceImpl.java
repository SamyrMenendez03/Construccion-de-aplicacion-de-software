package com.grupoA.backend.service;

import com.grupoA.backend.model.Categoria;
import com.grupoA.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
