package paucls.messagecontracts.shipping.adapter.messaging

const val EXCHANGE = "demo-exchange"

object RoutingKeys {
    const val ORDER_PLACED = "ordertaking.order.placed"
}

object Queues {
    const val ORDER_PLACED = "shipping.order.placed"
}
