package assignment3.remote.command;

public interface Command {
    void execute();
    void undo();
}