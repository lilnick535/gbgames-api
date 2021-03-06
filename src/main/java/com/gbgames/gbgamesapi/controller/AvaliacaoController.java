package com.gbgames.gbgamesapi.controller;


import java.util.List;
import java.util.Optional;

import com.gbgames.gbgamesapi.exceptions.ResourceNotFoundException;
import com.gbgames.gbgamesapi.exceptions.ResponseStatusException;
import com.gbgames.gbgamesapi.model.Avaliacao;
import com.gbgames.gbgamesapi.service.AvaliacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/avaliacoes")
    public ResponseEntity<List<Avaliacao>> getAllAvaliacao(@RequestParam(required = false) String browserGameId) {
        if (browserGameId != null) {
            return ResponseEntity.ok().body(avaliacaoService.getAvaliacaoByBrowserGameId(browserGameId));
        }
        return ResponseEntity.ok().body(avaliacaoService.getAllAvaliacao());
    }

    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<Avaliacao> getAvaliacaoById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(avaliacaoService.getAvaliacaoById(id));
    }

    @PostMapping("/avaliacoes")
    public ResponseEntity < Avaliacao > createAvaliacao(@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.ok().body(this.avaliacaoService.createAvaliacao(avaliacao));
    }

    @PutMapping("/avaliacoes/{id}")
    public ResponseEntity<Optional<Avaliacao>> updateAvaliacao(@PathVariable String id, @RequestBody Avaliacao avaliacao) throws Exception {
        avaliacao.setId(id);
        return ResponseEntity.ok().body(this.avaliacaoService.updateAvaliacao(avaliacao, id));
    }

    @PutMapping("/avaliacoes/{id}/curtidas")
    public ResponseEntity<Optional<Avaliacao>> insertCurtidas(@PathVariable String id, @RequestParam String usuarioId) throws Exception {
        return ResponseEntity.ok().body(this.avaliacaoService.insertCurtidaIntoAvaliacao(id, usuarioId));
    }

    @DeleteMapping("/avaliacoes/{id}")
    public HttpStatus deleteAvaliacao(@PathVariable String id) throws ResourceNotFoundException, ResponseStatusException {
        this.avaliacaoService.deleteAvaliacao(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/avaliacoes/{id}/curtidas")
    public ResponseEntity<Optional<Avaliacao>> deleteCurtida(@PathVariable String id, @RequestParam String usuarioId) throws Exception {
        return ResponseEntity.ok().body(this.avaliacaoService.deleteCurtidaFromAvaliacao(id, usuarioId));
    }

    

}