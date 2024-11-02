package assignment3.orderprocessing.state;

import assignment3.orderprocessing.Order;

public class DeliveredState implements State {
    private Order order;

    public DeliveredState(Order order) {
        this.order = order;
    }

    @Override
    public void payOrder() {
        System.out.println("Order has already been paid.");
    }

    @Override
    public void shipOrder() {
        System.out.println("Order has already been shipped.");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Order has already been delivered.");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cannot be cancelled after delivery.");
    }
}
