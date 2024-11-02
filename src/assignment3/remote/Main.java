package assignment3.remote;

import assignment3.remote.command.*;
import assignment3.remote.devices.*;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(3);


        TV tv = new TV();
        Stereo stereo = new Stereo();
        Light light = new Light();


        Command turnTVOn = new TurnTVOn(tv);
        Command setStereoVolume = new SetVolume(stereo, 20);
        Command dimLights = new DimLights(light);


        remote.setCommand(0, turnTVOn);
        remote.setCommand(1, setStereoVolume);
        remote.setCommand(2, dimLights);


        remote.pressButton(0);
        remote.pressButton(1);
        remote.pressButton(2);

        System.out.println("--------------------");
        remote.pressUndo();
    }
}

