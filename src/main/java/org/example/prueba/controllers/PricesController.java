package org.example.prueba.controllers;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.prueba.controllers.api.PricesApi;
import org.example.prueba.model.api.ApiProductPricesResponse;
import org.example.prueba.services.PricesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/e-commerce")
public class PricesController implements PricesApi {

  private final PricesService pricesService;

  @Override
  public ResponseEntity<ApiProductPricesResponse> getProductPrices(
      @Valid @RequestParam(value = "application_date", required = false) LocalDateTime applicationDate,
      @Valid @RequestParam(value = "product_id", required = false) Integer productId,
      @Valid @RequestParam(value = "brand_id", required = false) Integer brandId) {

    return pricesService.searchPrices(brandId, productId, applicationDate);
  }

}
