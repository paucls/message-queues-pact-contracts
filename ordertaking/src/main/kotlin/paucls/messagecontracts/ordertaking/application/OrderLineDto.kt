package paucls.messagecontracts.ordertaking.application

class OrderLineDto(
        val id: String?,
        val productCode: String,
        val orderQuantity: Number,
        val price: Number
)