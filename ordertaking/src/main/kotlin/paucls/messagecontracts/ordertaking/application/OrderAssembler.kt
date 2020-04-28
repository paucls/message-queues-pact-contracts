package paucls.messagecontracts.ordertaking.application

import paucls.messagecontracts.ordertaking.domain.Order
import paucls.messagecontracts.ordertaking.domain.OrderLine
import java.util.UUID

class OrderAssembler {

    fun toOrderDto(order: Order): OrderDto {
        return OrderDto(
                orderId = order.orderId,
                customerId = order.customerId,
                billingAddress = order.billingAddress,
                shippingAddress = order.shippingAddress,
                orderLines = order.orderLines.map {
                    OrderLineDto(
                            id = it.id,
                            orderId = it.orderId,
                            productCode = it.productCode,
                            quantity = it.quantity,
                            price = it.price
                    )
                },
                total = order.total
        )
    }

    fun toOrder(orderId: UUID, order: OrderDto): Order {
        return Order(
                orderId = orderId,
                customerId = order.customerId,
                billingAddress = order.billingAddress,
                shippingAddress = order.shippingAddress,
                orderLines = order.orderLines.map { toOrderLine(orderId, it) },
                total = order.total
        )
    }

    private fun toOrderLine(orderId: UUID, line: OrderLineDto): OrderLine {
        return OrderLine(
                orderId = orderId,
                productCode = line.productCode,
                quantity = line.quantity,
                price = line.price
        )
    }

}
