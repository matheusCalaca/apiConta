package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class BillResource {

    @Autowired
    lateinit var service: BillService

    @PostMapping("/bill")
    fun postBill(@RequestBody bill: Bill): Bill {
        return service.save(bill)
    }

    @PutMapping("/bill/{id}")
    fun putBill(@PathVariable("id") id: Long, @RequestBody bill: Bill): Bill {
        return service.update(id, bill)
    }

}
