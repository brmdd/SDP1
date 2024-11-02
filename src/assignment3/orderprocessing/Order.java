package assignment3.orderprocessing;

import assignment3.orderprocessing.state.*;

public class Order {
    private State newState;
    private State paidState;
    private State shippedState;
    private State deliveredState;
    private State cancelledState;

    private State currentState;

    public Order() {
        newState = new NewState(this);
        paidState = new PaidState(this);
        shippedState = new ShippedState(this);
        deliveredState = new DeliveredState(this);
        cancelledState = new CancelledState(this);

        currentState = newState; // Initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getNewState() {
        return newState;
    }

    public State getPaidState() {
        return paidState;
    }

    public State getShippedState() {
        return shippedState;
    }

    public State getDeliveredState() {
        return deliveredState;
    }

    public State getCancelledState() {
        return cancelledState;
    }

    public void payOrder() {
        currentState.payOrder();
    }

    public void shipOrder() {
        currentState.shipOrder();
    }

    public void deliverOrder() {
        currentState.deliverOrder();
    }

    public void cancelOrder() {
        currentState.cancelOrder();
    }
}
