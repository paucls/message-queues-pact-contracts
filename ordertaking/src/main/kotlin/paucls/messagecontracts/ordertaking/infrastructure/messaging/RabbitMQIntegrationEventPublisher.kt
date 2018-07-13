package paucls.messagecontracts.ordertaking.infrastructure.messaging

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Service
import paucls.messagecontracts.ordertaking.application.IntegrationEventPublisher

/**
 * Publish Integration Events, sending them as messages to RabbitMQ, for other micro-services to consume
 */
@Service
class RabbitMQIntegrationEventPublisher(
        private val rabbit: RabbitTemplate,
        private val messageConverter: MessageConverter
) : IntegrationEventPublisher {

    private val logger = LoggerFactory.getLogger(RabbitMQIntegrationEventPublisher::class.java)

    override fun publish(routingKey: String, event: Any) {
        logger.info("Publishing integration event ...", event)

        rabbit.convertAndSend(
                "demo-exchange",
                routingKey,
                messageConverter.toMessage(event, MessageProperties())
        )
    }

}