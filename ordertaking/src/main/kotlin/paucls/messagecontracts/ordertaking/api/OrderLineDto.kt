package paucls.messagecontracts.ordertaking.api

class OrderLineDto(
        val id: String?,
        val productCode: String,
        val orderQuantity: Number,
        val price: Number
)