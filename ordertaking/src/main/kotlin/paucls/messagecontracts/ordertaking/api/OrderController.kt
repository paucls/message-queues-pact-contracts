package paucls.messagecontracts.ordertaking.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import paucls.messagecontracts.ordertaking.application.OrderService

@Controller
class OrderController(
        val orderService: OrderService
) {

    @RequestMapping(value = ["/orders"], method = [(RequestMethod.POST)])
    fun placeOrder(@RequestBody orderDto: OrderDto): ResponseEntity<OrderDto> {
        orderService.placeOrder()

        return ResponseEntity(orderDto, HttpStatus.CREATED)
    }

}