package paucls.messagecontracts.ordertaking.domain

import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "order_table")
data class Order(
        @Id
        val orderId: UUID,
        val customerId: String,
        val shippingAddress: String,
        val billingAddress: String,
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        @JoinColumn(name = "order_id")
        val orderLines: List<OrderLine>,
        val total: Double
) : AggregateRoot<OrderEvent>() {
    init {
        if (orderLines.isEmpty()) throw CannotPlaceOrderWithoutLines()

        registerEvent(OrderPlaced(order = this))
    }
}
