package org.akshat.demo;


import org.akshat.demo.PaymentGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

//        PaymentGateway paymentGateway = (PaymentGateway) context.getBean("paymentGateway");
//
//        paymentGateway.print();
    }
}