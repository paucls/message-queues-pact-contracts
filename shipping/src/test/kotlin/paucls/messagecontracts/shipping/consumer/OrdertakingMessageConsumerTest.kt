package paucls.messagecontracts.shipping.consumer

import au.com.dius.pact.consumer.MessagePactBuilder
import au.com.dius.pact.consumer.dsl.PactDslJsonBody
import au.com.dius.pact.consumer.junit.MessagePactProviderRule
import au.com.dius.pact.consumer.junit.PactVerification
import au.com.dius.pact.core.model.annotations.Pact
import au.com.dius.pact.core.model.messaging.MessagePact
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class OrdertakingMessageConsumerTest {

    @JvmField
    @Rule
    var mockProvider = MessagePactProviderRule("ordertaking", this)

    @Pact(provider = "ordertaking", consumer = "shipping")
    fun orderPlacedPact(builder: MessagePactBuilder): MessagePact {
        val body = PactDslJsonBody()
        body.stringValue("orderId", "order-id")
        body.stringValue("customerId", "customer-id")

        val metadata = HashMap<String, String>()
        metadata["contentType"] = "application/json"

        return builder.given("an order with id order-id has been placed")
                .expectsToReceive("order placed message")
                .withMetadata(metadata)
                .withContent(body)
                .toPact()
    }

    @Test
    @PactVerification(value = ["tasks-provider"], fragment = "orderPlacedPact")
    @Throws(Exception::class)
    fun taskCompleted() {
        val currentMessage = mockProvider.message

        val orderPlaced: OrderPlaced = jacksonObjectMapper().readValue(currentMessage)
        assertThat(orderPlaced.orderId).isEqualTo("order-id")
        assertThat(orderPlaced.customerId).isEqualTo("customer-id")
    }

}

class OrderPlaced(
        val orderId: String,
        val customerId: String
)
