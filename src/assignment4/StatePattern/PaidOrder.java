package assignment4.StatePattern;

class PaidOrder implements OrderState {
    public void next(Order order) {
        order.setState(new ShippedOrder());
    }

    public void prev(Order order) {
        order.setState(new NewOrder());
    }

    public void printStatus() {
        System.out.println("Order is paid.");
    }
}
