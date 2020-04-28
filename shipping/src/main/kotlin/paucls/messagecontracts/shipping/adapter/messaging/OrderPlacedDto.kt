package paucls.messagecontracts.shipping.adapter.messaging

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Date

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderPlacedDto(
        val orderId: String,
        val shippingAddress: String,
        val orderLines: List<OrderLineDto> = emptyList(),
        val timestamp: Date = Date()
)

data class OrderLineDto(
        val productCode: String,
        val quantity: Number
)
