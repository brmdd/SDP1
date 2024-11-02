package assignment3.payment;

import assignment3.payment.strategy.*;

public class Main {
    public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();

    cart.setPaymentStrategy(new CreditCardPayment());
    cart.checkout(150);

    cart.setPaymentStrategy(new PayPalPayment());
    cart.checkout(200);

    cart.setPaymentStrategy(new CryptoPayment());
    cart.checkout(500);
}
}