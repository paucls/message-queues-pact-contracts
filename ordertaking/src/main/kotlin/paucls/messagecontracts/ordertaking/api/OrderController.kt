package paucls.messagecontracts.ordertaking.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import paucls.messagecontracts.ordertaking.application.OrderService
import paucls.messagecontracts.ordertaking.application.PlaceOrder
import paucls.messagecontracts.ordertaking.domain.UnvalidatedOrder
import paucls.messagecontracts.ordertaking.domain.UnvalidatedOrderLine

@Controller
class OrderController(private val orderService: OrderService) {

    @RequestMapping(value = ["/orders"], method = [(RequestMethod.POST)])
    fun placeOrder(@RequestBody dto: OrderDto): ResponseEntity<OrderDto> {
        orderService.placeOrder(PlaceOrder(
                unvalidatedOrder = toUnvalidatedOrder(dto)
        ))

        // TODO read and return persisted order
        return ResponseEntity(dto, HttpStatus.CREATED)
    }

    fun toUnvalidatedOrder(dto: OrderDto): UnvalidatedOrder {
        return UnvalidatedOrder(
                customerId = dto.customerId,
                billingAddress = dto.billingAddress,
                shippingAddress = dto.shippingAddress,
                orderLines = dto.orderLines.map(::toUnvalidatedOrderLine)
        )
    }

    fun toUnvalidatedOrderLine(dto: OrderLineDto): UnvalidatedOrderLine {
        return UnvalidatedOrderLine(
                productCode = dto.productCode,
                orderQuantity = dto.orderQuantity,
                price = dto.price
        )
    }

}