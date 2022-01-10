package com.example.weatherservice.repository;

import com.example.weatherservice.entity.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Date> {
}
