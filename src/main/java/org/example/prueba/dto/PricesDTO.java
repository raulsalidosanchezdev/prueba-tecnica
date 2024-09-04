package org.example.prueba.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricesDTO {

  private Integer id;
  private Integer brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer priceList;
  private Integer productId;
  private Integer priority;
  private Float price;
  private String curr;

}
