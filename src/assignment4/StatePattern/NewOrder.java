package assignment4.StatePattern;

class NewOrder implements OrderState {
    public void next(Order order) {
        order.setState(new PaidOrder());
    }

    public void prev(Order order) {
        System.out.println("The order is in its root state.");
    }

    public void printStatus() {
        System.out.println("Order is in new state.");
    }
}
