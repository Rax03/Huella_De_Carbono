package org.example.services;


import org.example.entities.Categoria;
import org.example.repositorio.CategoriaRepository;

import java.util.List;

public class CategoriaService {
    private CategoriaRepository categoriaRepository = new CategoriaRepository();

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.getAllCategorias();
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.getCategoriaById(id);
    }

    public void saveCategoria(Categoria categoria) {
        categoriaRepository.saveCategoria(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteCategoria(id);
    }
}
