package example.api.services;

import example.api.open_weather.CityOwResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void getWeatherFromOpenWeather() {
        //given
        String cityNameToFind = "Warsaw";
        final var ws = new WeatherService();
        //when
        final CityOwResponse response = ws.getWeatherFromOpenWeather(cityNameToFind);
        //then
        final String resultCityName = response.getName();
        Assertions.assertEquals(resultCityName, cityNameToFind);
    }
}