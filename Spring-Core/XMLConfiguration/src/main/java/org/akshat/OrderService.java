package org.akshat;

public class OrderService {

    private PaymentService paymentService;

    // dependency injection
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
