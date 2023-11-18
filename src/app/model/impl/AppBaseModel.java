package app.model.impl;

import app.entity.Order;
import app.model.AppModel;

public class AppBaseModel implements AppModel {
    public double calcPayment(Order order){
        return order.getQuota() * order.getPrice();
    }
}
