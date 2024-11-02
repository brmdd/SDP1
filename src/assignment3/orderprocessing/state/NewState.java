package assignment3.orderprocessing.state;

import assignment3.orderprocessing.Order;

public class NewState implements State {
    private Order order;

    public NewState(Order order) {
        this.order = order;
    }

    @Override
    public void payOrder() {
        System.out.println("Order has been paid.");
        order.setState(order.getPaidState());
    }

    @Override
    public void shipOrder() {
        System.out.println("Order cannot be shipped before payment.");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Order cannot be delivered before payment.");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order has been cancelled.");
        order.setState(order.getCancelledState());
    }
}