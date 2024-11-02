package assignment3.remote.devices;

public class Light {
    private int brightness = 100;  // Default brightness

    public void on() {
        brightness = 100;
        System.out.println("Lights are ON at full brightness");
    }

    public void off() {
        System.out.println("Lights are OFF");
    }

    public void dim() {
        brightness = 50;
        System.out.println("Lights are DIMMED to 50%");
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        System.out.println("Lights brightness set to " + brightness + "%");
    }
}
