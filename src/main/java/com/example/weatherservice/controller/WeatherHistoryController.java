package com.example.weatherservice.controller;

import com.example.weatherservice.dto.WeatherHistoryDto;
import com.example.weatherservice.service.WeatherHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weather")
public class WeatherHistoryController {
    private final WeatherHistoryService weatherService;

    public WeatherHistoryController(WeatherHistoryService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherHistoryDto> getWeatherHistory(){
        return ResponseEntity.ok(weatherService.getWeatherHistory());
    }

}
