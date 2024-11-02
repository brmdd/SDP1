package assignment3.orderprocessing.state;

import assignment3.orderprocessing.Order;

public class PaidState implements State {
    private Order order;

    public PaidState(Order order) {
        this.order = order;
    }

    @Override
    public void payOrder() {
        System.out.println("Order has already been paid.");
    }

    @Override
    public void shipOrder() {
        System.out.println("Order has been shipped.");
        order.setState(order.getShippedState());
    }

    @Override
    public void deliverOrder() {
        System.out.println("Order cannot be delivered before shipping.");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order has been cancelled.");
        order.setState(order.getCancelledState());
    }
}
