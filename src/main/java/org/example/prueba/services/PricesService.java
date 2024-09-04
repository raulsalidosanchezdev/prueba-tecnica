package org.example.prueba.services;

import java.time.LocalDateTime;
import org.example.prueba.model.api.ApiProductPricesResponse;
import org.springframework.http.ResponseEntity;

public interface PricesService {

  ResponseEntity<ApiProductPricesResponse> searchPrices(Integer productId, Integer brandId,
      LocalDateTime applicationDate);

}
