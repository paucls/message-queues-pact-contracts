package paucls.messagecontracts.ordertaking.domain

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
        val orderId: String,
        val customerId: String,
        val shippingAddress: String,
        val billingAddress: String,
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        @JoinColumn(name = "order_id")
        val orderLines: List<OrderLine> = emptyList(),
        val total: Double
)
