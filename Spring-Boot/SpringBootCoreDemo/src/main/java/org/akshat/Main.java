package org.akshat;


import org.akshat.demo.PaymentGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

        PaymentGateway paymentGateway = (PaymentGateway) context.getBean("paymentGateway");

        System.out.println(paymentGateway.getType());
        System.out.println(paymentGateway.getRetryCount());
        System.out.println(paymentGateway.isEnabled());
        System.out.println(paymentGateway.getTimeout());
    }
}