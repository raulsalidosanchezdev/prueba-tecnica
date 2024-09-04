package org.example.prueba.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PRICES")
@Getter
@Setter
public class Prices implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name="BRAND_ID", nullable = false)
  private Integer brandId;

  @Column(name="START_DATE", nullable = false)
  private LocalDateTime startDate;

  @Column(name="END_DATE", nullable = false)
  private LocalDateTime endDate;

  @Column(name="PRICE_LIST", nullable = false)
  private Integer priceList;

  @Column(name="PRODUCT_ID", nullable = false)
  private Integer productId;

  @Column(name="PRIORITY", nullable = false)
  private Integer priority;

  @Column(name="PRICE", nullable = false)
  private Float price;

  @Column(name="CURR", nullable = false)
  private String curr;

}
