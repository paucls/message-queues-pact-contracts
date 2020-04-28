package paucls.messagecontracts.shipping.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessageConverterConfig {

    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter {
        val objectMapper = jacksonObjectMapper().registerKotlinModule()
        return Jackson2JsonMessageConverter(objectMapper)
    }
}
