package paucls.messagecontracts.ordertaking.domain

import java.util.Date
import java.util.UUID

sealed class OrderEvent {
    val timestamp = Date()
}

data class OrderPlaced(
        val orderId: UUID,
        val customerId: String,
        val shippingAddress: String,
        val orderLines: List<OrderLine>
) : OrderEvent() {
    constructor(order: Order) : this(
            orderId = order.orderId,
            customerId = order.customerId,
            shippingAddress = order.shippingAddress,
            orderLines = order.orderLines
    )
}
