package com.giovana.desafio1.service;

import com.giovana.desafio1.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
        double totalDisconto = order.getBasic() - (order.getBasic() * (order.getDiscount()/100));
        order.setBasic(totalDisconto);
        double valorFrete = shippingService.shipment(order);

        return valorFrete + order.getBasic();
    }

}
