package org.example.prueba.mapper;

import org.example.prueba.dto.PricesDTO;
import org.example.prueba.dao.entities.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesDTOMapper {

  PricesDTOMapper INSTANCE = Mappers.getMapper(PricesDTOMapper.class);

  PricesDTO entityToDTO(Prices prices);

}
