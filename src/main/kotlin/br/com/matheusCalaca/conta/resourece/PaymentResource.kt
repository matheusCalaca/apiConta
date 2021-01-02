package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Payment
import br.com.matheusCalaca.conta.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("payment")
class PaymentResource {

    @Autowired
    @Qualifier("paymentService")
    lateinit var service: PaymentService

    @PostMapping
    fun postPayment(@RequestBody payment: Payment): ResponseEntity<Payment> {
        val save = service.save(payment)
        return ResponseEntity.status(HttpStatus.CREATED).body(save)
    }

    @DeleteMapping("/{id}")
    fun deltePayment(@PathVariable("id") id: Long): ResponseEntity<String> {
        service.delete(id)
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso")
    }


}
