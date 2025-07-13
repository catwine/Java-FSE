package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

   /* @Transactional
     public List<Country> getAllCountries() {
        return countryRepository.findAll();
     } */

   @Transactional
   public Country findCountryByCode(String code) throws CountryNotFoundException {
       Optional<Country> result = countryRepository.findById(code);
       if (!result.isPresent()) {
           throw new CountryNotFoundException("Country with code " + code + " not found");
       }
       return result.get();
   }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        Country country = result.get();
        country.setName(name);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional
    public List<Country> searchByName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}
