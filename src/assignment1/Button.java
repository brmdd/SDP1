// UI Component interfaces
interface Button {
    void render();
}

interface TextField {
    void render();
}

// Concrete Button classes
class DarkThemeButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Theme Button");
    }
}

class LightThemeButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Theme Button");
    }
}

// Concrete TextField classes
class DarkThemeTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Dark Theme Text Field");
    }
}

class LightThemeTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Light Theme Text Field");
    }
}

// Abstract UIFactory
interface UIFactory {
    Button createButton();
    TextField createTextField();
}

// Concrete Factories
class DarkThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkThemeTextField();
    }
}

class LightThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightThemeButton();
    }

    @Override
    public TextField createTextField() {
        return new LightThemeTextField();
    }
}
