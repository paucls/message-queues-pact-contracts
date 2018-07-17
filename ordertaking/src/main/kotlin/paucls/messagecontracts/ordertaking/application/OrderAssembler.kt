package paucls.messagecontracts.ordertaking.application

import paucls.messagecontracts.ordertaking.domain.Order
import paucls.messagecontracts.ordertaking.domain.OrderLine

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
                            orderQuantity = it.orderQuantity,
                            price = it.price
                    )
                },
                total = order.total
        )
    }

    fun toOrder(orderId: String, order: OrderDto): Order {
        return Order(
                orderId = orderId,
                customerId = order.customerId,
                billingAddress = order.billingAddress,
                shippingAddress = order.shippingAddress,
                orderLines = order.orderLines.map { toOrderLine(orderId, it) },
                total = order.total
        )
    }

    private fun toOrderLine(orderId: String, line: OrderLineDto): OrderLine {
        return OrderLine(
                orderId = orderId,
                productCode = line.productCode,
                orderQuantity = line.orderQuantity,
                price = line.price
        )
    }

}