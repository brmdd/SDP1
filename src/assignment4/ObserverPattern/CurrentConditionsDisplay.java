
package assignment4.ObserverPattern;

public class CurrentConditionsDisplay implements Observer {
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Current conditions: " + temp + "C degrees and " + humidity + "% humidity.");
    }
}
