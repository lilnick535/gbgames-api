package com.gbgames.gbgamesapi.service;

import java.util.List;
import java.util.Optional;

import com.gbgames.gbgamesapi.exceptions.ResourceNotFoundException;
import com.gbgames.gbgamesapi.exceptions.ResponseStatusException;
import com.gbgames.gbgamesapi.model.Categoria;

public interface CategoriaService {

        Categoria createCategoria(Categoria categoria);
    
        Optional<Categoria>  updateCategoria(Categoria categoria, String id) throws ResourceNotFoundException;
    
        List<Categoria> getAllCategoria();
    
        Categoria getCategoriaById(String id) throws ResourceNotFoundException;
    
        void deleteCategoria(String id) throws ResourceNotFoundException, ResponseStatusException;
    
}
