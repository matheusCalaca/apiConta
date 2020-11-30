package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BillResource {

    @Autowired
    lateinit var service: BillService

    @PostMapping("/bill")
    fun postBil(@RequestBody bill: Bill): Bill {
        return service.save(bill)
    }

}
