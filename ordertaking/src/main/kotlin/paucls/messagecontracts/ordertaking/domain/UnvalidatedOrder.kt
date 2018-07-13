package paucls.messagecontracts.ordertaking.domain

class UnvalidatedOrder(
        val customerId: String,
        val shippingAddress: String,
        val billingAddress: String,
        val orderLines: List<UnvalidatedOrderLine> = emptyList()
)
