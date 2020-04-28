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
import paucls.messagecontracts.shipping.adapter.messaging.OrderLineDto
import paucls.messagecontracts.shipping.adapter.messaging.OrderPlacedDto
import java.util.UUID

class OrdertakingMessageConsumerTest {

    @JvmField
    @Rule
    var mockProvider = MessagePactProviderRule("ordertaking", this)

    @Pact(provider = "ordertaking", consumer = "shipping")
    fun orderPlacedPact(builder: MessagePactBuilder): MessagePact {
        val body = PactDslJsonBody()
                .uuid("orderId", UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .stringType("shippingAddress", "a shipping address")
                .array("orderLines")
                .`object`()
                .stringType("productCode", "product-code")
                .numberType("quantity", 10)
                .closeObject()

        val metadata = HashMap<String, String>()
        metadata["contentType"] = "application/json"

        return builder.given("an order has been placed")
                .expectsToReceive("order placed message")
                .withMetadata(metadata)
                .withContent(body)
                .toPact()
    }

    @Test
    @PactVerification(value = ["tasks-provider"], fragment = "orderPlacedPact")
    fun `should handle order placed message`() {
        val orderPlacedDto: OrderPlacedDto = jacksonObjectMapper().readValue(mockProvider.message)

        assertThat(orderPlacedDto.orderId).isEqualTo(UUID.fromString("00000000-0000-0000-0000-000000000000"))
        assertThat(orderPlacedDto.shippingAddress).isEqualTo("a shipping address")
        assertThat(orderPlacedDto.orderLines).containsExactly(
                OrderLineDto(productCode = "product-code", quantity = 10))
    }
}
