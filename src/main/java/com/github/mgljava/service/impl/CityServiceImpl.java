package com.github.mgljava.service.impl;

import com.github.mgljava.dao.CityDao;
import com.github.mgljava.domain.City;
import com.github.mgljava.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

  private final CityDao cityDao;

  @Override
  public List<City> findAllCity() {
    return cityDao.findAllCity();
  }

  @Override
  public City findCityById(Long id) {
    return cityDao.findById(id);
  }

  @Override
  public Long saveCity(City city) {
    return cityDao.saveCity(city);
  }

  @Override
  public Long updateCity(City city) {
    return cityDao.updateCity(city);
  }

  @Override
  public Long deleteCity(Long id) {
    return cityDao.deleteCity(id);
  }
}
