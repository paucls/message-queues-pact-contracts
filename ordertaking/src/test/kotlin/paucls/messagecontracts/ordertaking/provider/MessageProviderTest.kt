package paucls.messagecontracts.ordertaking.provider

import au.com.dius.pact.provider.PactVerifyProvider
import au.com.dius.pact.provider.junit.PactRunner
import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.State
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.AmqpTarget
import au.com.dius.pact.provider.junit.target.Target
import au.com.dius.pact.provider.junit.target.TestTarget
import org.junit.runner.RunWith

@RunWith(PactRunner::class)
@Provider("ordertaking")
@PactFolder("amqp_pacts")
class MessageProviderTest {
    @JvmField
    @TestTarget
    val target: Target = AmqpTarget(listOf("paucls.messagecontracts.ordertaking.provider.*"))

    @State("an order with id order-id has been placed")
    fun orderPlacedState() {
    }

    @PactVerifyProvider("order placed message")
    fun verifyOrderPlacedMessage(): String {
//        val order = Order()
//        return jacksonObjectMapper().writeValueAsString(order)
        return ""
    }
}