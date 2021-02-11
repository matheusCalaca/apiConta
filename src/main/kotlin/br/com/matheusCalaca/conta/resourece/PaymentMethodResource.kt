package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.PaymentMethod
import br.com.matheusCalaca.conta.service.PaymentMethodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("paymentMethod")
class PaymentMethodResource {

    @Autowired
    @Qualifier("paymentMethodService")
    lateinit var service: PaymentMethodService

    @PostMapping
    fun postPaymentMethod(@RequestBody paymentMethod: PaymentMethod): ResponseEntity<PaymentMethod> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paymentMethod))
    }

    @PutMapping("/{id}")
    fun putPaymentMethod(
        @PathVariable("id") id: Long,
        @RequestBody paymentMethod: PaymentMethod
    ): ResponseEntity<PaymentMethod> {
        return ResponseEntity.ok(service.update(id, paymentMethod))
    }

    @GetMapping("/all")
    fun getPaymentMethod(): ResponseEntity<Iterable<PaymentMethod>> {
        return ResponseEntity.ok(service.findAll())
    }

    @DeleteMapping("/{id}")
    fun putPaymentMethod(@PathVariable("id") id: Long): ResponseEntity<String> {
        service.delete(id)
        return ResponseEntity.ok("Deletado com sucesso")
    }
}
