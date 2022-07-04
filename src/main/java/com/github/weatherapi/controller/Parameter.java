package com.github.weatherapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("parameter")
public class Parameter {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public Object About() {
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/weather/{city}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public static Object Weather(@PathVariable("city") String city) {
        RestTemplate template = new RestTemplate();
        try {
            return template.getForEntity("http://api.openweathermap.org/data/2.5/weather?q=" + city
                    + "&appid=b3cb5187ca32d8ba0e4c5aa3c520f2d4", Object.class);
        } catch (HttpStatusCodeException exception) {
            return exception.getResponseBodyAsString();
        }
    }
}
