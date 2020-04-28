package paucls.messagecontracts.ordertaking.domain

import java.util.Date

sealed class OrderEvent {
    val timestamp = Date()
}

data class OrderPlaced(
        val orderId: String,
        val customerId: String,
        val shippingAddress: String
) : OrderEvent() {
    constructor(order: Order) : this(
            orderId = order.orderId,
            customerId = order.customerId,
            shippingAddress = order.shippingAddress
    )
}
