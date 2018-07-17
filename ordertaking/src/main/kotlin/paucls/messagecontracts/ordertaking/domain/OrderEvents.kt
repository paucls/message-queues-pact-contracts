package paucls.messagecontracts.ordertaking.domain

import java.util.Date

sealed class OrderEvent {
    val timestamp = Date()
}

data class OrderPlaced(val orderId: String) : OrderEvent()
