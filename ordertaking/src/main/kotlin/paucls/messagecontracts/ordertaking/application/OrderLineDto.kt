package paucls.messagecontracts.ordertaking.application

class OrderLineDto(
        val id: String?,
        val orderId: String?,
        val productCode: String,
        val quantity: Number,
        val price: Number
)
