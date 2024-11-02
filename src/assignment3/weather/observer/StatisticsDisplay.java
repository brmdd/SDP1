package assignment3.weather.observer;

public class StatisticsDisplay implements WeatherDisplay {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        // Assuming some statistical calculations are made here
        System.out.println("Statistics: Avg Temp = " + (temperature + 1) + "°C, Avg Humidity = " + (humidity + 2) + "%");
    }
}