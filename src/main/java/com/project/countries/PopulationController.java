package com.project.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {
    // localhost:2019/population/size/{people}
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getPopEqualToOrGreaterThan(@PathVariable int people) {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
    // localhost:2019/population/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLeastPop() {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }
    // localhost:2019/population/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMostPop() {
        ArrayList<Country> rtnCountries = CountriesApplication.myCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }
}
