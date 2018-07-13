package paucls.messagecontracts.ordertaking.application

/**
 * Publish Integration Events for other micro-services to consume
 */
interface IntegrationEventPublisher {
    fun publish(routingKey: String, event: Any)
}