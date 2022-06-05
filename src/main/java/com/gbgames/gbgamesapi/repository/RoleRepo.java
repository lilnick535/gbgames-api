package com.gbgames.gbgamesapi.repository;

import java.util.Optional;

import com.gbgames.gbgamesapi.model.EnumRole;
import com.gbgames.gbgamesapi.model.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role, String> {
        Optional<Role> findByNome(EnumRole nome);
    
}
