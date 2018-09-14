package com.github.mgljava.dao;

import com.github.mgljava.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author: Monk date: 2018年9月6日19:34:46 desc：mapper
 */
@Mapper
public interface CityDao {

    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
