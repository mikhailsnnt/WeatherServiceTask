package com.example.weatherservice.service.impl;

import com.example.weatherservice.entity.WeatherHistory;
import com.example.weatherservice.service.WeatherReadingService;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WeatherReadingServiceImpl implements WeatherReadingService {
    private static final Logger logger = LogManager.getLogger();
    @SneakyThrows
    @Override
    public WeatherHistory retrieveWeatherFromExternalSource() {
        URL parseUrl = new URL("https://yandex.ru");
        try(BufferedReader bufferedReader = new BufferedReader(  new InputStreamReader(parseUrl.openStream())))
        {
            Date date = new Date(System.currentTimeMillis());
            logger.info("Retrieving temperature for date: " + date.toString());
            StringBuilder responseStringBuilder = new StringBuilder();
            String nextLine;
            while((nextLine = bufferedReader.readLine())!=null){
                responseStringBuilder.append(nextLine);
            }          //Get http response from yandex.ru
            Pattern pattern = Pattern.compile("<div class='weather__temp'>(.+?)</div>");  //Find current temperature element via Regex
            Matcher matcher = pattern.matcher(responseStringBuilder.toString());
            matcher.find();
            String temperature =matcher.group(1);
            return  new WeatherHistory(date,temperature);
        }
    }
}