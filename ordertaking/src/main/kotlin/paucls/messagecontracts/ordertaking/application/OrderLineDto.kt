package paucls.messagecontracts.ordertaking.application

import java.util.UUID

class OrderLineDto(
        val id: String?,
        val orderId: UUID?,
        val productCode: String,
        val quantity: Number,
        val price: Number
)
