package com.gbgames.gbgamesapi.repository;

import com.gbgames.gbgamesapi.model.Categoria;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends MongoRepository<Categoria, String>{
}
    
