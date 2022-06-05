package com.gbgames.gbgamesapi.repository;

import java.util.List;

import com.gbgames.gbgamesapi.model.BrowserGame;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowserGameRepo extends MongoRepository<BrowserGame, String>{

    List<BrowserGame> findByCategoriaId(String categoriaId, Sort sort);

}
    
