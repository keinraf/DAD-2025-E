package com.example.ms_catalogo.service.impl;

import com.example.ms_catalogo.entity.Categoria;
import com.example.ms_catalogo.repisitory.CategoriaRepository;
import com.example.ms_catalogo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class CategoriaServiseImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }


    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    @Override
    public Categoria actualizar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    @Override
    public Optional<Categoria> listarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }


    @Override
    public void eliminarPorId(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
