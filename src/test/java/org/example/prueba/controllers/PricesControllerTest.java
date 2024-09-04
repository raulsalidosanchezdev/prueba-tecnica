package org.example.prueba.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerTest {

  public static final String BASE_URL = "/e-commerce/prices";

  @Autowired
  MockMvc mockMvc;

  @Test
  void application_date_2020_06_14_10_00_should_get_product_with_price_35_50() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
        BASE_URL.concat("?application_date=2020-06-14T10:00:00&product_id=35455&brand_id=1")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", is(35455)))
        .andExpect(jsonPath("$.brand_id", is(1)))
        .andExpect(jsonPath("$.price_list", is(1)))
        .andExpect(jsonPath("$.start_date", is("2020-06-14T00:00:00")))
        .andExpect(jsonPath("$.end_date", is("2020-12-31T23:59:59")))
        .andExpect(jsonPath("$.price", is(35.50)));
  }

  @Test
  void application_date_2020_06_14_16_00_should_get_product_with_price_25_45() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
            BASE_URL.concat("?application_date=2020-06-14T16:00:00&product_id=35455&brand_id=1")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", is(35455)))
        .andExpect(jsonPath("$.brand_id", is(1)))
        .andExpect(jsonPath("$.price_list", is(2)))
        .andExpect(jsonPath("$.start_date", is("2020-06-14T15:00:00")))
        .andExpect(jsonPath("$.end_date", is("2020-06-14T18:30:00")))
        .andExpect(jsonPath("$.price", is(25.45)));
  }

  @Test
  void application_date_2020_06_14_16_21_00_should_get_product_with_price_35_50_21_00() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
            BASE_URL.concat("?application_date=2020-06-14T21:00:00&product_id=35455&brand_id=1")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", is(35455)))
        .andExpect(jsonPath("$.brand_id", is(1)))
        .andExpect(jsonPath("$.price_list", is(1)))
        .andExpect(jsonPath("$.start_date", is("2020-06-14T00:00:00")))
        .andExpect(jsonPath("$.end_date", is("2020-12-31T23:59:59")))
        .andExpect(jsonPath("$.price", is(35.50)));
  }

  @Test
  void application_date_2020_06_15_10_00_should_get_product_with_price_30_50() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
            BASE_URL.concat("?application_date=2020-06-15T10:00:00&product_id=35455&brand_id=1")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", is(35455)))
        .andExpect(jsonPath("$.brand_id", is(1)))
        .andExpect(jsonPath("$.price_list", is(3)))
        .andExpect(jsonPath("$.start_date", is("2020-06-15T00:00:00")))
        .andExpect(jsonPath("$.end_date", is("2020-06-15T11:00:00")))
        .andExpect(jsonPath("$.price", is(30.50)));
  }

  @Test
  void application_date_2020_06_16_21_00_should_get_product_with_price_38_95() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
            BASE_URL.concat("?application_date=2020-06-16T21:00:00&product_id=35455&brand_id=1")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", is(35455)))
        .andExpect(jsonPath("$.brand_id", is(1)))
        .andExpect(jsonPath("$.price_list", is(4)))
        .andExpect(jsonPath("$.start_date", is("2020-06-15T16:00:00")))
        .andExpect(jsonPath("$.end_date", is("2020-12-31T23:59:59")))
        .andExpect(jsonPath("$.price", is(38.95)));
  }

  @Test
  void application_date_2023_06_16_21_00_should_get_204_NO_CONTENT() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
            BASE_URL.concat("?application_date=2023-06-16T21:00:00&product_id=35455&brand_id=1")))
        .andExpect(status().isNoContent());
  }



}