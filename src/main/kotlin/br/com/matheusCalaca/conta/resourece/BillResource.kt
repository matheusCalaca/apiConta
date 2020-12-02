package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
class BillResource {


    @Autowired
    lateinit var service: BillService

    @PostMapping("/bill")
    fun postBill(@RequestBody bill: Bill): Bill {
        return service.save(bill)
    }

    @GetMapping("/bill")
    fun getBill(@RequestParam("page") page: Long, @RequestParam("size") size: Long): List<Bill> {
        return service.getBills(page, size)
    }

    @PutMapping("/bill/{id}")
    fun putBill(@PathVariable("id") id: Long, @RequestBody bill: Bill): Bill {
        return service.update(id, bill)
    }

    @DeleteMapping("/bill/{id}")
    fun deleteBill(@PathVariable("id") id: Long): String {
        service.delete(id)
        return "Deletado com sucesso!"
    }

}
