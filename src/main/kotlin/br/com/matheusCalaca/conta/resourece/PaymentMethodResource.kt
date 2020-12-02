package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.service.PaymentMethodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentMethodResource {

    @Autowired
    lateinit var service: PaymentMethodService

    @PostMapping("/paymentMethod")
    fun postPaymentMethod(@RequestBody paymentMethod: PaymentMethod): PaymentMethod {
        return service.save(paymentMethod)
    }
}
