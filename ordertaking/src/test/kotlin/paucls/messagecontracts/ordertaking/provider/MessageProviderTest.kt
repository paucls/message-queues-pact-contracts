package paucls.messagecontracts.ordertaking.provider

import au.com.dius.pact.provider.PactVerifyProvider
import au.com.dius.pact.provider.junit.PactRunner
import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.State
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.AmqpTarget
import au.com.dius.pact.provider.junit.target.Target
import au.com.dius.pact.provider.junit.target.TestTarget
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.runner.RunWith
import paucls.messagecontracts.ordertaking.domain.OrderLine
import paucls.messagecontracts.ordertaking.domain.OrderPlaced
import java.util.UUID

@RunWith(PactRunner::class)
@Provider("ordertaking")
@PactFolder("pacts")
class MessageProviderTest {

    @JvmField
    @TestTarget
    val target: Target = AmqpTarget(listOf("paucls.messagecontracts.ordertaking.provider.*"))

    @State("an order has been placed")
    fun orderPlacedState() {
    }

    @PactVerifyProvider("order placed message")
    fun verifyOrderPlacedMessage(): String {
        val orderId = UUID.randomUUID()
        val order = OrderPlaced(
                orderId = orderId,
                customerId = "customer-id",
                shippingAddress = "a shipping address",
                orderLines = listOf(OrderLine(
                        orderId = orderId,
                        productCode = "product-code",
                        quantity = 1,
                        price = 100
                ))
        )
        return jacksonObjectMapper().writeValueAsString(order)
    }
}
