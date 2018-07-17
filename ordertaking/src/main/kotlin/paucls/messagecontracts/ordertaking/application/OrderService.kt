package paucls.messagecontracts.ordertaking.application

import org.springframework.stereotype.Service
import paucls.messagecontracts.ordertaking.domain.Order
import java.util.UUID

@Service
class OrderService(private val repository: OrderRepository) {

    val assembler = OrderAssembler()

    fun placeOrder(unvalidatedOrder: OrderDto): OrderDto {
        val orderId = UUID.randomUUID().toString()
        var order = Order(
                orderId = orderId,
                customerId = unvalidatedOrder.customerId,
                billingAddress = unvalidatedOrder.billingAddress,
                shippingAddress = unvalidatedOrder.shippingAddress,
                orderLines = unvalidatedOrder.orderLines.map { assembler.toOrderLine(orderId, it) },
                total = unvalidatedOrder.total
        )

        order = repository.save(order)

        return assembler.toOrderDto(order)
    }

}
