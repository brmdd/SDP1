package assignment4.StatePattern;

class DeliveredOrder implements OrderState {
    public void next(Order order) {
        System.out.println("The order is already delivered.");
    }

    public void prev(Order order) {
        order.setState(new ShippedOrder());
    }

    public void printStatus() {
        System.out.println("Order is delivered.");
    }
}
