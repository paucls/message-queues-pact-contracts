package paucls.messagecontracts.ordertaking.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "order_table")
class Order(
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid2")
        val orderId: String,
        val customerId: String,
        val shippingAddress: String,
        val billingAddress: String,
        @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true)
        @JoinColumn(name = "order_id")
        val orderLines: List<OrderLine> = emptyList(),
        val amountToBill: Number?
)
