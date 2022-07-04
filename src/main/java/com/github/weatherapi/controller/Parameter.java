package com.github.weatherapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/")
public class Parameter {

    @GetMapping(value = "/about")
    public Object about() {
        return HttpStatus.OK;
    }

    @GetMapping(value = "/weather/{city}")
    public ResponseEntity<Object> weather(@PathVariable("city") String city) {
        return new ResponseEntity<>(new RestTemplate().getForEntity(
                "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=b3cb5187ca32d8ba0e4c5aa3c520f2d4",
                Object.class), HttpStatus.OK);
    }

}
