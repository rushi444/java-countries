package com.project.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names")
public class NameController {
    // returns names of countries alphabetically
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
       CountriesApplication.myCountryList.countryList.sort((e1, e2) ->
               e1.getName().compareToIgnoreCase(e2.getName()));
       return new ResponseEntity<>(CountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }


}
