package paucls.messagecontracts.ordertaking.application

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OrderService(private val repository: OrderRepository) {

    val assembler = OrderAssembler()

    fun placeOrder(unvalidatedOrder: OrderDto): OrderDto {
        val orderId = UUID.randomUUID().toString()
        var order = assembler.toOrder(orderId, unvalidatedOrder)

        order = repository.save(order)

        return assembler.toOrderDto(order)
    }

}
