package com.example.weatherservice.service;

import com.example.weatherservice.entity.WeatherHistory;

public interface WeatherReadingService {
    WeatherHistory retrieveWeatherFromExternalSource();
}

