package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.service.PaymentMethodService
import org.apache.juli.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
class PaymentMethodResource {

    @Autowired
    lateinit var service: PaymentMethodService

    @PostMapping("/paymentMethod")
    fun postPaymentMethod(@RequestBody paymentMethod: PaymentMethod): PaymentMethod {
        return service.save(paymentMethod)
    }

    @PutMapping("/paymentMethod/{id}")
    fun putPaymentMethod(@PathVariable("id") id: Long, @RequestBody paymentMethod: PaymentMethod): PaymentMethod {
        return service.update(id, paymentMethod)
    }

    @GetMapping("/paymentMethod/all")
    fun getPaymentMethod(): Iterable<PaymentMethod> {
        return service.findAll()
    }

    @DeleteMapping("/paymentMethod/{id}")
    fun putPaymentMethod(@PathVariable("id") id: Long): String {
        service.delete(id)
        return "Deletado com sucesso"
    }
}
