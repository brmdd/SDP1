package assignment3.weather.observer;

public class CurrentConditionsDisplay implements WeatherDisplay {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current conditions: Temperature = " + temperature + "°C, Humidity = " + humidity + "%, Pressure = " + pressure + " Pa");
    }
}