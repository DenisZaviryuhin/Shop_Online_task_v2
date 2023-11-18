package app.model.impl;

import app.entity.Order;
import app.model.AppModel;
import app.utility.Constants;

public class AppWithDeliveryModel implements AppModel {


    @Override
    public double calcPayment(Order order) {
        double cost = order.getQuota() * order.getPrice();
        double deliveryCost = (cost / 100) * Constants.DELIVERY_RATE;
        return cost + deliveryCost ;
    }
}
