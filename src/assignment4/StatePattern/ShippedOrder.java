package assignment4.StatePattern;

class ShippedOrder implements OrderState {
    public void next(Order order) {
        order.setState(new DeliveredOrder());
    }

    public void prev(Order order) {
        order.setState(new PaidOrder());
    }

    public void printStatus() {
        System.out.println("Order is shipped.");
    }
}

