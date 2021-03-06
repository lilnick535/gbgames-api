package com.gbgames.gbgamesapi.service.impl;

import java.util.List;
import java.util.Optional;

import com.gbgames.gbgamesapi.exceptions.ResourceNotFoundException;
import com.gbgames.gbgamesapi.exceptions.ResponseStatusException;
import com.gbgames.gbgamesapi.model.Usuario;
import com.gbgames.gbgamesapi.repository.UsuarioRepo;
import com.gbgames.gbgamesapi.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario, String usuarioId) throws ResourceNotFoundException {
      
        Usuario savedUsuario = usuarioRepo.save(usuario);
        if (!savedUsuario.equals(null)){
            return savedUsuario;
        } else {
            throw new ResourceNotFoundException("404", "Record not found with id : " + usuarioId);
        }

    }

    @Override
    public Boolean  verifyUsuarioExistsByUsername(String username) {
        Boolean usuarioDb = this.usuarioRepo.existsByUsername(username);
        return usuarioDb;
    }


    @Override
    public List<Usuario> getAllUsuario() {
        return this.usuarioRepo.findAll();
    }

    @Override
    public Usuario getUsuarioById(String usuarioId) throws ResourceNotFoundException {

        Optional<Usuario> usuarioDb = this.usuarioRepo.findById(usuarioId);

        if (usuarioDb.isPresent()) {
            return usuarioDb.get();
        } else {
            throw new ResourceNotFoundException("404", "Record not found with id : " + usuarioId);
        }
    }

    @Override
    public void deleteUsuario(String usuarioId) throws ResourceNotFoundException, ResponseStatusException {

            Optional<Usuario> usuarioDb = this.usuarioRepo.findById(usuarioId);

            if (usuarioDb.isPresent()) {
                this.usuarioRepo.delete(usuarioDb.get());
            } else {
                throw new ResourceNotFoundException("404", "Record not found with id : " + usuarioId);
            }
        

    }
}
