package app.controller;

import app.entity.Customer;
import app.entity.Order;
import app.model.impl.AppBaseModel;
import app.model.impl.AppWithDeliveryModel;
import app.utility.Constants;
import app.utility.Rounder;
import app.view.AppView;

import java.util.Scanner;

public class AppController {
    public static int getOption() {
        System.out.println("""
                Shop Online
                -----------
                Choose an order option:
                
                \u0031\uFE0F\u20E3 - Order with pickup.
                \u0032\uFE0F\u20E3 - Order with delivery.
                """);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void runOption(int option) {
        switch (option) {
            case 1 -> {
                AppController appController = new AppController();
                appController.getPayment();
            }
            case 2 -> {
                AppController appController = new AppController();
                appController.getPaymentWithDelivery();
            }
        }


    }

    public void getPayment() {
        AppView view = new AppView();
        String[] data = view.getData();
        Customer customer = getCustomer(data);
        Order order = getOrder(data);
        String output;
        AppBaseModel model = new AppBaseModel();
        String payment = Rounder.roundValue(model.calcPayment(order));
        output = "\nClient: " + customer.getName() + "\nPhone number: " + customer.getPhone() +
                "\nPayment is " + Constants.CURRENCY + " " + payment;
        view.getOutput(output);


    }

    public void getPaymentWithDelivery() {
        AppView view = new AppView();
        String[] data = view.getData();
        Customer customer = getCustomer(data);
        Order order = getOrder(data);
        String address = view.getDeliveryAddress();
        String output;
        AppWithDeliveryModel deliveryModel = new AppWithDeliveryModel();
        String paymentWithDelivery = Rounder.roundValue(deliveryModel.calcPayment(order));
        output = "\nClient: " + customer.getName() + "\nPhone number: " + customer.getPhone() + "\nAddress: "
               + address + "\nPayment with delivery is " + Constants.CURRENCY + " " + paymentWithDelivery;
        view.getOutput(output);
    }

    private Customer getCustomer(String[] data) {
        return new Customer(data[0], data[1]);
    }

    private Order getOrder(String[] data) {
        return new Order(Integer.parseInt(data[2]),Double.parseDouble(data[3]));

    }

}


