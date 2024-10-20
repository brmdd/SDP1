import java.util.ArrayList;
import java.util.List;

abstract class MenuComponent {
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

// Step 2: MenuItem class for individual dishes
class MenuItem extends MenuComponent {
    String name;
    String description;
    double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("Item: " + getName() + ", " + getDescription() + ", $" + getPrice());
    }
}

// Step 3: Menu class that can contain MenuComponents (either MenuItem or other Menu objects)
class Menu extends MenuComponent {
    String name;
    String description;
    List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.println("\nMenu: " + getName() + ", " + getDescription());
        System.out.println("----------------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}

// Step 5: RestaurantApp class to demonstrate multi-level menu structure
class RestaurantApp {
    public static void main(String[] args) {
        MenuComponent mainMenu = new Menu("Main Menu", "All main dishes");
        MenuComponent dessertMenu = new Menu("Dessert Menu", "Sweet treats");
        MenuComponent drinksMenu = new Menu("Drinks Menu", "Beverages");

        MenuComponent pizza = new MenuItem("Pizza", "Italian delight", 8.99);
        MenuComponent burger = new MenuItem("Burger", "American classic", 5.99);
        MenuComponent iceCream = new MenuItem("Ice Cream", "Vanilla flavor", 3.50);
        MenuComponent coffee = new MenuItem("Coffee", "Fresh brewed", 2.50);

        mainMenu.add(pizza);
        mainMenu.add(burger);
        dessertMenu.add(iceCream);
        drinksMenu.add(coffee);

        mainMenu.add(dessertMenu);
        mainMenu.add(drinksMenu);

        mainMenu.print();
    }
}
