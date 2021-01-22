package org.mddarr.order.request.service.services.orders;


import org.mddarr.order.request.service.Constants;
import org.mddarr.order.request.service.dto.orders.OrderRequest;


import org.mddarr.orders.event.dto.AvroOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AvroOrderRequestProducer implements AvroOrderRequestInterface {

    @Autowired
    private KafkaTemplate<String, AvroOrder> kafkaTemplateEvent1;

    private static final Logger logger = LoggerFactory.getLogger(AvroOrderRequestProducer.class);

    public void sendRideRequest(OrderRequest orderRequest) {
        AvroOrder avroOrder = AvroOrder.newBuilder().build();


//        AvroOrder order = AvroOrder.newBuilder()
//                .setId(UUID.randomUUID().toString())
//                .setCustomerId(orderRequest.getCustomerID())
//                .setPrice(12.2)
//                .setProducts(orderRequest.getProducts())
//                .setVendors(orderRequest.getVendors())
//                .setQuantites(orderRequest.getQuantities())
//                .setState(OrderState.PENDING)
//                .build();
//        logger.info("Send order {}", order);
//        kafkaTemplateEvent1.send(Constants.ORDER_TOPIC, order);
    }

}
