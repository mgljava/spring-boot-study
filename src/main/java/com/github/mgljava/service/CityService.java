package com.github.mgljava.service;

import com.github.mgljava.domain.City;
import java.util.List;

public interface CityService {

  List<City> findAllCity();

  City findCityById(Long id);

  Long saveCity(City city);

  Long updateCity(City city);

  Long deleteCity(Long id);
}
