package org.example.prueba.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.prueba.dao.repositories.PricesRepository;
import org.example.prueba.dto.PricesDTO;
import org.example.prueba.mapper.PricesDTOMapper;
import org.example.prueba.mapper.ProductPricesResponseMapper;
import org.example.prueba.model.api.ApiProductPricesResponse;
import org.example.prueba.services.PricesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

  private final PricesRepository pricesRepository;

  @Override
  public ResponseEntity<ApiProductPricesResponse> searchPrices(Integer brandId, Integer productId,
      LocalDateTime applicationDate) {

    Optional<PricesDTO> pricesDTO = Optional.ofNullable(PricesDTOMapper.INSTANCE.entityToDTO(pricesRepository.
        findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            brandId, productId, applicationDate, applicationDate)));

    return pricesDTO
        .map(dto -> ResponseEntity.ok(ProductPricesResponseMapper.INSTANCE.dtoToProductPricesResponse(dto)))
        .orElseGet(() -> new ResponseEntity<>(new ApiProductPricesResponse(), HttpStatus.NO_CONTENT));
  }

}
