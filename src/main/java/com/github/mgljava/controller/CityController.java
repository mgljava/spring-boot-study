package com.github.mgljava.controller;

import com.github.mgljava.domain.City;
import com.github.mgljava.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CityController {

    private final CityService cityService;

    @GetMapping(value = "/api/city/{id}")
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @GetMapping(value = "/api/city")
    public String findAllCity(Model model) {
        List<City> cities = cityService.findAllCity();
        model.addAttribute("cityList", cities);
        return "cityList";
    }
}
