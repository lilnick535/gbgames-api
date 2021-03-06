package com.gbgames.gbgamesapi.controller;

import java.util.List;
import java.util.Optional;

import com.gbgames.gbgamesapi.exceptions.ResourceNotFoundException;
import com.gbgames.gbgamesapi.exceptions.ResponseStatusException;
import com.gbgames.gbgamesapi.model.Categoria;
import com.gbgames.gbgamesapi.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        return ResponseEntity.ok().body(categoriaService.getAllCategoria());
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(categoriaService.getCategoriaById(id));
    }

    @PostMapping("/categorias")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity < Categoria > createCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok().body(this.categoriaService.createCategoria(categoria));
    }

    @PutMapping("/categorias/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Categoria>> updateCategoria(@PathVariable String id, @RequestBody Categoria categoria) throws ResourceNotFoundException {
        categoria.setId(id);
        return ResponseEntity.ok().body(this.categoriaService.updateCategoria(categoria, id));
    }

    @DeleteMapping("/categorias/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HttpStatus deleteCategoria(@PathVariable String id) throws ResourceNotFoundException, ResponseStatusException {
        this.categoriaService.deleteCategoria(id);
        return HttpStatus.OK;
    }
}
