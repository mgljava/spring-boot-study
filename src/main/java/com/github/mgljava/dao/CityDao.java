package com.github.mgljava.dao;

import com.github.mgljava.domain.City;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * author: Monk date: 2018年9月6日19:34:46 desc：mapper
 */
public interface CityDao {

  List<City> findAllCity();

  City findById(@Param("id") Long id);

  Long saveCity(City city);

  Long updateCity(City city);

  Long deleteCity(Long id);
}
