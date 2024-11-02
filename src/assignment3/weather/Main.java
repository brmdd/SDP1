package assignment3.weather;


public class Main {
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();


        WeatherData weatherData = new WeatherData(weatherStation);


        weatherData.updateWeather(25.0f, 65.0f, 1013.0f);
        System.out.println("-------------------");
        weatherData.updateWeather(28.0f, 70.0f, 1015.0f);
    }
}