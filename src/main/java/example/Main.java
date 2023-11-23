package example;

import example.api.HttpClientService;
import example.api.open_weather.CityOwResponse;
import example.api.services.WeatherService;
import example.handlers.FindCityByNameHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "C" -> new FindCityByNameHandler().handle();
                default -> System.out.println("ERROR! INVALID INPUT!");
                }
            }
        }

    private static boolean showWelcomeMenu(boolean isFirstRun) {
        if (isFirstRun) {
            System.out.println("""
                    -----
                    WELCOME!
                    type X to quit
                    type C to show what city you want to find
                    ------""");
            isFirstRun = false;
        }
        return isFirstRun;
    }
}
