package assignment3.remote.command;

import assignment3.remote.devices.TV;

public class TurnTVOn implements Command {
    private TV tv;

    public TurnTVOn(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}