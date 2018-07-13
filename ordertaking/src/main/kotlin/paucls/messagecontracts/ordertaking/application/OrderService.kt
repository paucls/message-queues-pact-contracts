package paucls.messagecontracts.ordertaking.application

import org.springframework.stereotype.Service
import paucls.messagecontracts.ordertaking.domain.Order
import paucls.messagecontracts.ordertaking.domain.OrderLine
import paucls.messagecontracts.ordertaking.domain.UnvalidatedOrderLine
import java.util.UUID

@Service
class OrderService(private val repository: OrderRepository) {

    fun placeOrder(c: PlaceOrder): Order {
        val orderId = UUID.randomUUID().toString()

        val order = Order(
                orderId = orderId,
                customerId = c.unvalidatedOrder.customerId,
                billingAddress = c.unvalidatedOrder.billingAddress,
                shippingAddress = c.unvalidatedOrder.shippingAddress,
                orderLines = c.unvalidatedOrder.orderLines.map { toOrderLine(orderId, it) },
                amountToBill = 0 // TODO
        )

        return repository.save(order)
    }

    fun toOrderLine(orderId: String, line: UnvalidatedOrderLine): OrderLine {
        return OrderLine(
                orderId = orderId,
                productCode = line.productCode,
                orderQuantity = line.orderQuantity,
                price = line.price
        )
    }

}