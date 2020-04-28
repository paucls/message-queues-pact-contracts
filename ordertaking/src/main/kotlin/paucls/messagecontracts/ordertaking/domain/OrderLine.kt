package paucls.messagecontracts.ordertaking.domain

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
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
        val orderId: UUID,
        val productCode: String,
        val quantity: Number,
        val price: Number
)
