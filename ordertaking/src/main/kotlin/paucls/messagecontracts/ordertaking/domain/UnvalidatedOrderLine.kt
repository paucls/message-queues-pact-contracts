package paucls.messagecontracts.ordertaking.domain

class UnvalidatedOrderLine(
        val productCode: String,
        val orderQuantity: Number,
        val price: Number
)