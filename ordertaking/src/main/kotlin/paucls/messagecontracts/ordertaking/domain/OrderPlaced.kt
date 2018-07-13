package paucls.messagecontracts.ordertaking.domain

import java.util.Date

class OrderPlaced(val orderId: String) {
    val timestamp = Date()
}
