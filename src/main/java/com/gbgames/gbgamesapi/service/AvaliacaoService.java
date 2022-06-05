package com.gbgames.gbgamesapi.service;

import java.util.List;
import java.util.Optional;

import com.gbgames.gbgamesapi.exceptions.ResourceNotFoundException;
import com.gbgames.gbgamesapi.exceptions.ResponseStatusException;
import com.gbgames.gbgamesapi.model.Avaliacao;

public interface AvaliacaoService {

        Avaliacao createAvaliacao(Avaliacao avaliacao);
    
        Optional<Avaliacao>  updateAvaliacao(Avaliacao avaliacao, String id) throws ResourceNotFoundException, Exception;
    
        List<Avaliacao> getAllAvaliacao();

        List<Avaliacao> getAvaliacaoByBrowserGameId(String browserGameId);
    
        Avaliacao getAvaliacaoById(String id) throws ResourceNotFoundException;
    
        void deleteAvaliacao(String id) throws ResourceNotFoundException, ResponseStatusException;

        Optional<Avaliacao> insertCurtidaIntoAvaliacao(String id, String usuarioId) throws Exception;

        Optional<Avaliacao> deleteCurtidaFromAvaliacao(String id, String usuarioId) throws Exception;

    
}
