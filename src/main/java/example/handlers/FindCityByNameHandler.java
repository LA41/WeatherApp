package example.handlers;

import example.api.open_weather.CityOwResponse;
import example.api.services.WeatherService;

import java.util.Scanner;

public class FindCityByNameHandler {
    public void handle(){
        System.out.println("Type a city to find: ");
        Scanner cityToFind = new Scanner(System.in);
        String userInputCityToFind = cityToFind.nextLine();
        //wyszukać miasto
        final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather(userInputCityToFind);
        String message = """
                            City weather data from [%s]:
                            - city name:    [%s],
                            - wind speed:   [%s],
                            - temp:         [%s],
                            - pressure:     [%s],
                            """.formatted(
                weatherFromOpenWeather.getDt(),
                weatherFromOpenWeather.getName(),
                weatherFromOpenWeather.getWind().getSpeed(),
                weatherFromOpenWeather.getMain().getTemp(),
                weatherFromOpenWeather.getMain().getPressure()
        );
        System.out.println(message);
    }
}
