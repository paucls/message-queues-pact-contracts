package paucls.messagecontracts.ordertaking.application

import org.springframework.data.jpa.repository.JpaRepository
import paucls.messagecontracts.ordertaking.domain.Order

interface OrderRepository : JpaRepository<Order, String>