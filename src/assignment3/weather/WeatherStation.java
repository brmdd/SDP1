package assignment3.weather;

import assignment3.weather.observer.WeatherDisplay;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<WeatherDisplay> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void registerObserver(WeatherDisplay observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherDisplay observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherDisplay observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();  // Notify all observers of the new data
    }
}