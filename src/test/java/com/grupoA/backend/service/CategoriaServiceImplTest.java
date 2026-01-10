package com.grupoA.backend.service;

import com.grupoA.backend.model.Categoria;
import com.grupoA.backend.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaServiceImplTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultar() {
        // 1. Preparar datos falsos (Mock)
        Categoria cat1 = new Categoria("Tecnologia", "Laptops");
        Categoria cat2 = new Categoria("Hogar", "Muebles");
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(cat1, cat2));

        // 2. Ejecutar el metodo a probar
        List<Categoria> resultado = categoriaService.findAll();

        // 3. Verificar (Assert)
        assertNotNull(resultado);
        assertEquals(2, resultado.size()); // Esperamos 2 categorias
        assertEquals("Tecnologia", resultado.get(0).getNombre());
        verify(categoriaRepository, times(1)).findAll();
    }

    @Test
    void testGuardar() {
        // 1. Preparar dato
        Categoria categoria = new Categoria("Juguetes", "Juegos de mesa");
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        // 2. Ejecutar
        Categoria resultado = categoriaService.save(categoria);

        // 3. Verificar
        assertNotNull(resultado);
        assertEquals("Juguetes", resultado.getNombre());
        verify(categoriaRepository, times(1)).save(categoria);
    }
}