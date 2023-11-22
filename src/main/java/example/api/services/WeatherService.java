package example.api.services;

import example.api.HttpClientService;
import example.api.open_weather.CityOwResponse;

public class WeatherService {

    public CityOwResponse getWeatherFromOpenWeather(String cityName) {
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
        String appIdQuery = "appid=716238e6166ce6e1315daf3232959cd3";
        String cityNameQuery = "q=" + cityName;
        String unitsQuery = "units=metric";

        String openWeatherUrl = baseUrl + appIdQuery + "&" + cityNameQuery + "&" + unitsQuery;


        var httpClientService = new HttpClientService<CityOwResponse>();
        final CityOwResponse response = httpClientService.getWeather(openWeatherUrl, CityOwResponse.class);

        return response;
    }

}