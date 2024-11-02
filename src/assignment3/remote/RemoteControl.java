package assignment3.remote;

import assignment3.remote.command.Command;

public class RemoteControl {
    private Command[] commandSlots;
    private Command lastCommand;

    public RemoteControl(int slots) {
        commandSlots = new Command[slots];
    }

    public void setCommand(int slot, Command command) {
        if (slot < commandSlots.length) {
            commandSlots[slot] = command;
        }
    }

    public void pressButton(int slot) {
        if (slot < commandSlots.length && commandSlots[slot] != null) {
            commandSlots[slot].execute();
            lastCommand = commandSlots[slot];  // Save last executed command for undo
        } else {
            System.out.println("No command set for slot " + slot);
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo");
        }
    }
}
