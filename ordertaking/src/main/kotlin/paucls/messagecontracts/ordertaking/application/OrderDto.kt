package paucls.messagecontracts.ordertaking.application

class OrderDto(
        val orderId: String?,
        val customerId: String,
        val shippingAddress: String,
        val billingAddress: String,
        val orderLines: List<OrderLineDto> = emptyList(),
        val total: Double
)
