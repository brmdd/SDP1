interface Pizza {
    String getDescription();
    double getCost();
}

class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 6.99;
    }
}

class VegetarianPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Vegetarian Pizza";
    }

    @Override
    public double getCost() {
        return 7.99;
    }
}

abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}

class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.75;
    }
}

class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();
        System.out.println(pizza.getDescription() + " - Cost: $" + pizza.getCost());

        pizza = new CheeseTopping(pizza);
        pizza = new MushroomTopping(pizza);
        System.out.println(pizza.getDescription() + " - Cost: $" + pizza.getCost());
    }
}
