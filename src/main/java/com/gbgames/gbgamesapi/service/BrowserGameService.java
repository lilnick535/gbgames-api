package com.gbgames.gbgamesapi.service;

import java.util.List;
import java.util.Optional;

import com.gbgames.gbgamesapi.dto.response.BrowserGamesStarsResponseDTO;
import com.gbgames.gbgamesapi.model.BrowserGame;

public interface BrowserGameService {
    
    BrowserGame createBrowserGame(BrowserGame browserGame);
    
    Optional<BrowserGame>  updateBrowserGame(BrowserGame browserGame, String id);
    
    List<BrowserGame> getAllBrowserGame();

    List<BrowserGame> getBrowserGameByCategoriaId(String categoriaId);

    List<BrowserGame> getBrowserGamesRecomendationById(String usuarioId);

    List<BrowserGamesStarsResponseDTO> getBrowserGamesStars();

    BrowserGame getBrowserGameById(String id);
    
    void deleteBrowserGame(String id);
}
