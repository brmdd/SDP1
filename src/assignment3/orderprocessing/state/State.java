package assignment3.orderprocessing.state;

public interface State {
    void payOrder();
    void shipOrder();
    void deliverOrder();
    void cancelOrder();
}