package com.project.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NameController {
    // returns countries alphabetically
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
       CountriesApplication.myCountryList.countryList.sort((e1, e2) ->
               e1.getName().compareToIgnoreCase(e2.getName()));
       return new ResponseEntity<>(CountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}", produces  = {"application/json"})
    public ResponseEntity<?> getCountriesStartingWith(@PathVariable char letter){
       ArrayList<Country> rtnCountries = CountriesApplication.myCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
       rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
       return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }
    @GetMapping(value = "/size/{num}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithEqualOrLongerLength(@PathVariable int num) {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountryList.findCountries(c -> c.getName().length() >= num);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK); 
    }


}
