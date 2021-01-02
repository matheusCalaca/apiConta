package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.service.PaymentMethodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("paymentMethod")
class PaymentMethodResource {

    @Autowired
    @Qualifier("paymentMethodService")
    lateinit var service: PaymentMethodService

    @PostMapping
    fun postPaymentMethod(@RequestBody paymentMethod: PaymentMethod): PaymentMethod {
        return service.save(paymentMethod)
    }

    @PutMapping("/{id}")
    fun putPaymentMethod(@PathVariable("id") id: Long, @RequestBody paymentMethod: PaymentMethod): PaymentMethod {
        return service.update(id, paymentMethod)
    }

    @GetMapping("/all")
    fun getPaymentMethod(): Iterable<PaymentMethod> {
        return service.findAll()
    }

    @DeleteMapping("/{id}")
    fun putPaymentMethod(@PathVariable("id") id: Long): String {
        service.delete(id)
        return "Deletado com sucesso"
    }
}
