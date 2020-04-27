package paucls.messagecontracts.shipping.adapter.messaging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.ExchangeTypes
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.annotation.Queue
import org.springframework.amqp.rabbit.annotation.QueueBinding
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class OrderPlacedHandler {

    private val logger: Logger = LoggerFactory.getLogger(OrderPlacedHandler::class.java)

    @RabbitListener(
            bindings = [(QueueBinding(
                    value = Queue(value = Queues.ORDER_PLACED, durable = "true"),
                    exchange = Exchange(EXCHANGE, type = ExchangeTypes.TOPIC, durable = "true", autoDelete = "false"),
                    key = [RoutingKeys.ORDER_PLACED]))]
    )
    fun handleMessage(message: OrderPlacedDto) {
        logger.info("Received order placed message $message")

        // here we will call an application use case
        // ...
    }
}
