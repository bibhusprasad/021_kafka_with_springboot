package com.bibhu.learn.kafka.handler;

import com.bibhu.learn.kafka.message.OrderCreated;
import com.bibhu.learn.kafka.service.DispatchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class OrderCreatedHandler {

    private DispatchService dispatchService;

    @KafkaListener(
            id = "orderConsumerClient",
            topics = "order.created",
            groupId = "dispatch.order.created.consumer"
    )
    public void listen(OrderCreated payload) {
        log.info("OrderCreatedHandler received payload: {}", payload);
        dispatchService.process(payload);
    }
}
