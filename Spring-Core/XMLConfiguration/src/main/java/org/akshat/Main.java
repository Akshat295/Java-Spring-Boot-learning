package org.akshat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
//            System.out.println("Hello World");
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

            // get bean by id/name

            OrderService orderService = (OrderService) context.getBean("orderService");
            orderService.placeOrder();

            // get bean by type
//            OrderService orderService1 = context.getBean(OrderService.class);
//            orderService1.placeOrder();
//
//            // safest option
//            OrderService orderService2 = context.getBean("orderService",OrderService.class);
//            orderService2.placeOrder();



        }
    }