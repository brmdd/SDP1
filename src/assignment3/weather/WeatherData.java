package assignment3.weather;

import assignment3.weather.observer.CurrentConditionsDisplay;
import assignment3.weather.observer.StatisticsDisplay;
import assignment3.weather.observer.ForecastDisplay;

public class WeatherData {
    private WeatherStation weatherStation;

    public WeatherData(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;

        // Register different displays as observers
        weatherStation.registerObserver(new CurrentConditionsDisplay());
        weatherStation.registerObserver(new StatisticsDisplay());
        weatherStation.registerObserver(new ForecastDisplay());
    }

    public void updateWeather(float temperature, float humidity, float pressure) {
        weatherStation.setWeatherData(temperature, humidity, pressure);
    }
}