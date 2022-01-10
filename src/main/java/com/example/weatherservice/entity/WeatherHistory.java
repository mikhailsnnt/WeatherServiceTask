package com.example.weatherservice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "weather_history")
public class WeatherHistory {
    @Id
    @Column(name = "weather_date")
    private Date date;
    @Column(name = "weather_value", nullable = false)
    private String temperature;
}
