package paucls.messagecontracts.shipping.adapter.messaging

data class OrderPlacedDto(
        val orderId: String,
        val customerId: String
)
