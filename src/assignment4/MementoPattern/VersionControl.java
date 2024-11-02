package assignment4.MementoPattern;

public class VersionControl {
    private DocumentMemento savedState;

    public void saveState(DocumentMemento state) {
        savedState = state;
    }

    public DocumentMemento getSavedState() {
        return savedState;
    }
}
