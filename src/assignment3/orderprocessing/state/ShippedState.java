package assignment3.orderprocessing.state;

import assignment3.orderprocessing.Order;

public class ShippedState implements State {
    private Order order;

    public ShippedState(Order order) {
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
        System.out.println("Order has been delivered.");
        order.setState(order.getDeliveredState());
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order cannot be cancelled after it has been shipped.");
    }
}
