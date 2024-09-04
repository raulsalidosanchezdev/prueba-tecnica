package org.example.prueba.dao.repositories;

import java.time.LocalDateTime;
import org.example.prueba.dao.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

  Prices findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
      Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate);

}
