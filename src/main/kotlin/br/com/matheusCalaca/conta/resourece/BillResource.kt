package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.DTO.ConfTableDto
import br.com.matheusCalaca.conta.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("bill")
class BillResource {

    @Autowired
    @Qualifier("billService")
    lateinit var service: BillService

    @PostMapping
    fun postBill(@RequestBody bill: Bill): ResponseEntity<Bill> {
        val creatBill = service.creatBill(bill)
        return ResponseEntity.status(HttpStatus.CREATED).body(creatBill)
    }

    @GetMapping
    fun getBill(@RequestParam("page") page: Long, @RequestParam("size") size: Long): ResponseEntity<List<Bill>> {
        return ResponseEntity.ok(service.getBills(page, size))
    }

    @GetMapping("/confTable")
    fun getBillConf(): ResponseEntity<ConfTableDto> {
        return ResponseEntity.ok(service.getBillsConf())
    }

    @PutMapping("/{id}")
    fun putBill(@PathVariable("id") id: Long, @RequestBody bill: Bill): ResponseEntity<Bill> {
        val update = service.update(id, bill)
        return ResponseEntity.ok(update)
    }

    @DeleteMapping("/{id}")
    fun deleteBill(@PathVariable("id") id: Long): ResponseEntity<String> {
        service.delete(id)
        return ResponseEntity.ok("Deletado com sucesso!")
    }

}
