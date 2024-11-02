package assignment3.remote.command;

import assignment3.remote.devices.Stereo;

public class SetVolume implements Command {
    private Stereo stereo;
    private int volume;
    private int previousVolume;

    public SetVolume(Stereo stereo, int volume) {
        this.stereo = stereo;
        this.volume = volume;
    }

    @Override
    public void execute() {
        previousVolume = stereo.getVolume();
        stereo.setVolume(volume);
    }

    @Override
    public void undo() {
        stereo.setVolume(previousVolume);
    }
}