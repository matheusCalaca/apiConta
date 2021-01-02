package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("bill")
class BillResource {

    @Autowired
    @Qualifier("billService")
    lateinit var service: BillService

    @PostMapping
    fun postBill(@RequestBody bill: Bill): Bill {
        return service.creatBill(bill)
    }

    @GetMapping
    fun getBill(@RequestParam("page") page: Long, @RequestParam("size") size: Long): List<Bill> {
        return service.getBills(page, size)
    }

    @PutMapping("/{id}")
    fun putBill(@PathVariable("id") id: Long, @RequestBody bill: Bill): Bill {
        return service.update(id, bill)
    }

    @DeleteMapping("/{id}")
    fun deleteBill(@PathVariable("id") id: Long): String {
        service.delete(id)
        return "Deletado com sucesso!"
    }

}
