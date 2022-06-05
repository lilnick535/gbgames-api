package com.gbgames.gbgamesapi.service;

import com.gbgames.gbgamesapi.dto.response.RelatorioResponseDTO;

public interface RelatorioService {
    
    RelatorioResponseDTO getRelatorio(Integer tipoRelatorio, long dataInicial, long dataFinal);
}
