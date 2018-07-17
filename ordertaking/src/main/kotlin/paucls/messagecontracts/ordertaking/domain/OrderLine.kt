package paucls.messagecontracts.ordertaking.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class OrderLine(
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid2")
        val id: String? = null,
        @Column(name = "order_id")
        val orderId: String,
        val productCode: String,
        val orderQuantity: Number,
        val price: Number
)