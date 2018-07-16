package paucls.messagecontracts.ordertaking.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import paucls.messagecontracts.ordertaking.application.OrderDto
import paucls.messagecontracts.ordertaking.application.OrderService
import paucls.messagecontracts.ordertaking.application.PlaceOrder

@Controller
class OrderController(private val orderService: OrderService) {

    @RequestMapping(value = ["/orders"], method = [(RequestMethod.POST)])
    fun placeOrder(@RequestBody dto: OrderDto): ResponseEntity<OrderDto> {
        orderService.placeOrder(PlaceOrder(unvalidatedOrder = dto))

        // TODO read and return persisted order
        return ResponseEntity(dto, HttpStatus.CREATED)
    }
}
