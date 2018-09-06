package com.github.mgljava.controller;

import com.github.mgljava.domain.City;
import com.github.mgljava.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/cities")
public class CityRestController {

  private final CityService cityService;

  @GetMapping(value = "/{id}")
  public City findOneCity(@PathVariable("id") Long id) {
    return cityService.findCityById(id);
  }

  @GetMapping(value = "/")
  public List<City> findAllCity() {
    return cityService.findAllCity();
  }

  @PostMapping(value = "/")
  public void createCity(@RequestBody City city) {
    cityService.saveCity(city);
  }

  @PutMapping(value = "/")
  public void modifyCity(@RequestBody City city) {
    cityService.updateCity(city);
  }

  @DeleteMapping(value = "/{id}")
  public void modifyCity(@PathVariable("id") Long id) {
    cityService.deleteCity(id);
  }
}
