package com.gbgames.gbgamesapi.service;

import java.util.List;

import com.gbgames.gbgamesapi.exceptions.ResourceNotFoundException;
import com.gbgames.gbgamesapi.exceptions.ResponseStatusException;
import com.gbgames.gbgamesapi.model.Usuario;

public interface UsuarioService {

        Usuario createUsuario(Usuario usuario);
    
        Usuario  updateUsuario(Usuario usuario, String id) throws ResourceNotFoundException;

        Boolean  verifyUsuarioExistsByUsername(String username);
    
        List<Usuario> getAllUsuario();
    
        Usuario getUsuarioById(String id) throws ResourceNotFoundException;
    
        void deleteUsuario(String id) throws ResourceNotFoundException, ResponseStatusException;
    
}
