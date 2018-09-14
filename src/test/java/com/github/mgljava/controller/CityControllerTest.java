package com.github.mgljava.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.mgljava.domain.City;
import com.github.mgljava.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CityControllerTest {

  private MockMvc mockMvc;

  @Mock
  private CityService cityService;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(new CityController(cityService)).build();
  }

  @Test
  void should_get_city_object() throws Exception {
    // given
    Long id = 1L;
    final City chengdu = City.builder().cityName("chengdu").build();

    // when
    when(cityService.findCityById(id)).thenReturn(chengdu);

    // then
    this.mockMvc.perform(get("/api/city/{id}", 1L))
        .andExpect(status().isOk());
  }
}
