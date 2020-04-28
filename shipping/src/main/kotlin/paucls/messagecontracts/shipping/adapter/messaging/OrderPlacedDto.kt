package paucls.messagecontracts.shipping.adapter.messaging

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Date
import java.util.UUID

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderPlacedDto(
        val orderId: UUID,
        val shippingAddress: String,
        val orderLines: List<OrderLineDto> = emptyList(),
        val timestamp: Date = Date()
)

data class OrderLineDto(
        val productCode: String,
        val quantity: Number
)
