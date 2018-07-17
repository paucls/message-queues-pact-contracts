package paucls.messagecontracts.ordertaking.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class OrderTest {

    @Test
    fun `can place order`() {
        val orderId = "order-id"
        val order = Order(
                orderId = orderId,
                customerId = "customer-id",
                billingAddress = "address 1",
                shippingAddress = "address 2",
                orderLines = listOf(
                        OrderLine(
                                id = "order-line-id",
                                orderId = orderId,
                                productCode = "a1",
                                price = 1.5,
                                orderQuantity = 4
                        )
                ),
                total = 6.0
        )

        assertThat(order.domainEvents()).containsExactly(OrderPlaced(orderId))
    }

    @Test
    fun `can not place order without lines`() {
        Assertions.assertThatThrownBy {
            Order(
                    orderId = "order-id",
                    customerId = "customer-id",
                    billingAddress = "address 1",
                    shippingAddress = "address 2",
                    orderLines = emptyList(),
                    total = 0.0
            )
        }.isInstanceOf(CannotPlaceOrderWithoutLines::class.java)
    }
}