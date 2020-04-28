package paucls.messagecontracts.shipping.adapter.messaging

data class OrderPlacedDto(
        val orderId: String,
        val shippingAddress: String,
        val orderLines: List<OrderLineDto> = emptyList()
)

data class OrderLineDto(
        val productCode: String,
        val quantity: Number
)
