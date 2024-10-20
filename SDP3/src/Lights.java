class Lights {
    public void turnOn() {
        System.out.println("Lights are ON");
    }

    public void turnOff() {
        System.out.println("Lights are OFF");
    }
}

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Thermostat set to " + temperature + " degrees");
    }
}

class SecuritySystem {
    public void arm() {
        System.out.println("Security system armed");
    }

    public void disarm() {
        System.out.println("Security system disarmed");
    }
}

class EntertainmentSystem {
    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class SmartHomeFacade {
    private Lights lights;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;
    private EntertainmentSystem entertainmentSystem;

    public SmartHomeFacade() {
        lights = new Lights();
        thermostat = new Thermostat();
        securitySystem = new SecuritySystem();
        entertainmentSystem = new EntertainmentSystem();
    }

    public void leaveHome() {
        lights.turnOff();
        thermostat.setTemperature(18);
        securitySystem.arm();
        System.out.println("Leaving home...");
    }

    public void arriveHome() {
        lights.turnOn();
        thermostat.setTemperature(22);
        securitySystem.disarm();
        System.out.println("Arrived home...");
    }

    public void nightMode() {
        lights.turnOff();
        thermostat.setTemperature(20);
        securitySystem.arm();
        System.out.println("Night mode activated...");
    }

    public void movieMode(String movie) {
        lights.turnOff();
        thermostat.setTemperature(22);
        entertainmentSystem.playMovie(movie);
        System.out.println("Movie mode activated...");
    }
}

class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();

        smartHome.arriveHome();
        smartHome.movieMode("The Matrix");
        smartHome.nightMode();
        smartHome.leaveHome();
    }
}
