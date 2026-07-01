package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Solution {
    public static void main(String[] args) {
        SpringApplication.run(Solution.class, args);
    }

    @Bean
    CommandLineRunner run(CountryService countryService) {
        return args -> {
            countryService.addCountry(new Country("IN", "India"));
            countryService.addCountry(new Country("US", "United States"));
            System.out.println(countryService.getAllCountries());
        };
    }
}
