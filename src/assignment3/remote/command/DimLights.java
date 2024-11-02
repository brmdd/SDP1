package assignment3.remote.command;

import assignment3.remote.devices.Light;

public class DimLights implements Command {
    private Light light;
    private int previousBrightness;

    public DimLights(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousBrightness = light.getBrightness();
        light.dim();
    }

    @Override
    public void undo() {
        light.setBrightness(previousBrightness);
    }
}
