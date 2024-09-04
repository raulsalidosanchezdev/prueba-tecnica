package org.example.prueba.mapper;

import org.example.prueba.dto.PricesDTO;
import org.example.prueba.model.api.ApiProductPricesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPricesResponseMapper {

  ProductPricesResponseMapper INSTANCE = Mappers.getMapper(ProductPricesResponseMapper.class);

  ApiProductPricesResponse dtoToProductPricesResponse(PricesDTO pricesDTO);

}
