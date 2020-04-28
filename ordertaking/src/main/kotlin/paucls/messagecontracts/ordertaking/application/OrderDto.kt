package paucls.messagecontracts.ordertaking.application

import java.util.UUID

class OrderDto(
        val orderId: UUID?,
        val customerId: String,
        val shippingAddress: String,
        val billingAddress: String,
        val orderLines: List<OrderLineDto> = emptyList(),
        val total: Double
)
