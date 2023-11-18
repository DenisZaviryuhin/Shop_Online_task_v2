package app.model;

import app.entity.Order;

public interface AppModel {
    double calcPayment(Order order);

}
