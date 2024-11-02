package assignment4.StatePattern;

interface OrderState {
    void next(Order order);

    void prev(Order order);

    void printStatus();
}
