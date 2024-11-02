package assignment3.weather.observer;

public class ForecastDisplay implements WeatherDisplay {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        // Assuming some simple forecast logic
        System.out.println("Forecast: Temp will be " + (temperature + 2) + "°C tomorrow.");
    }
}