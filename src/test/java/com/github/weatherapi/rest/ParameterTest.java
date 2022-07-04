package com.github.weatherapi.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParameterTest {
    @Autowired private TestRestTemplate testRestTemplate;

    @Test void weatherTest(){
        ResponseEntity<String> response = testRestTemplate
                .exchange("/api/v1/weather/ananindeua", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
