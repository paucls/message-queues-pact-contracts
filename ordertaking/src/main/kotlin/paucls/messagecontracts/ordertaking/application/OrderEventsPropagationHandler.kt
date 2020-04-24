package paucls.messagecontracts.ordertaking.application

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import paucls.messagecontracts.ordertaking.domain.OrderPlaced

/**
 * This handler listens for Order domain events, that other micro-services are interested in,
 * and propagates them as integration events.
 */
@Component
class OrderEventsPropagationHandler(
        private val eventPublisher: IntegrationEventPublisher
) {

    @EventListener
    fun handle(event: OrderPlaced) {
        eventPublisher.publish("ordertaking.events", event)
    }

}
