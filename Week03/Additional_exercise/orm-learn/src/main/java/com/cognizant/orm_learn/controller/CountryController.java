package com.cognizant.orm_learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/co")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET /countries/IN
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }

    // GET /countries/search?name=ind
    @GetMapping("/search")
    public List<Country> searchCountriesByName(@RequestParam String name) {
        return countryService.searchByName(name);
    }

    // POST /countries
    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    // PUT /countries/ZZ
    @PutMapping("/{code}")
    public void updateCountry(@PathVariable String code, @RequestBody Country country) throws CountryNotFoundException {
        countryService.updateCountry(code, country.getName());
    }

    // DELETE /countries/ZZ
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }
}
