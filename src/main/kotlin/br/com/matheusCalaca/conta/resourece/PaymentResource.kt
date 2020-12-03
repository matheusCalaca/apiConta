package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Payment
import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.service.PaymentMethodService
import br.com.matheusCalaca.conta.service.PaymentService
import org.apache.juli.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
class PaymentResource {

    @Autowired
    lateinit var service: PaymentService

    @PostMapping("/payment")
    fun postPayment(@RequestBody payment: Payment): Payment{
        return service.save(payment)
    }

    @DeleteMapping("/payment/{id}")
    fun deltePayment(@PathVariable("id") id: Long): String{
        service.delete(id)
        return "Deletado com sucesso"
    }


}
