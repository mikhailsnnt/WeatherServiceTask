package com.example.weatherservice.service.impl;


import com.example.weatherservice.dto.WeatherHistoryDto;
import com.example.weatherservice.entity.WeatherHistory;
import com.example.weatherservice.repository.WeatherHistoryRepository;
import com.example.weatherservice.service.WeatherHistoryService;
import com.example.weatherservice.service.WeatherReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class WeatherHistoryServiceImpl implements WeatherHistoryService {
    private final WeatherHistoryRepository repository;
    private final WeatherReadingService readingService;
    @Autowired
    public WeatherHistoryServiceImpl(WeatherHistoryRepository repository, WeatherReadingService readingService) {
        this.repository = repository;
        this.readingService = readingService;
    }

    @Override
    public WeatherHistoryDto getWeatherHistory() {
        Date requestDate = new Date(System.currentTimeMillis());
        WeatherHistory weatherHistoryEntity;
        if(repository.existsById(requestDate))
            weatherHistoryEntity = repository.getById(requestDate);
        else{
            weatherHistoryEntity = readingService.retrieveWeatherFromExternalSource();
            repository.save(weatherHistoryEntity);
        }
        return mapToDto(weatherHistoryEntity);
    }


    private WeatherHistoryDto mapToDto(WeatherHistory entity){
        return  new WeatherHistoryDto(entity.getDate().toString(), entity.getTemperature());
    }
}
