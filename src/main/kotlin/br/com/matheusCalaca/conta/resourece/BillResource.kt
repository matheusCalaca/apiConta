package br.com.matheusCalaca.conta.resourece

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.DTO.BillDto
import br.com.matheusCalaca.conta.model.DTO.ConfTableDto
import br.com.matheusCalaca.conta.model.mapper.MapperBill
import br.com.matheusCalaca.conta.service.BillService
import org.mapstruct.factory.Mappers
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
    fun postBill(@RequestHeader("Authorization") token: String, @RequestBody billDto: BillDto): ResponseEntity<Bill> {

        val converter = Mappers.getMapper(MapperBill::class.java)
        val bill = converter.convertToModel(billDto)

        val creatBill = service.creatBill(token, bill)
        return ResponseEntity.status(HttpStatus.CREATED).body(creatBill)
    }

    @GetMapping
    fun getBill(
        @RequestHeader("Authorization") token: String,
        @RequestParam("page") page: Long,
        @RequestParam("size") size: Long,
        @RequestParam("year", required = false) year: String?,
        @RequestParam("month", required = false) month: String?
    ): ResponseEntity<List<Bill>> {
        return ResponseEntity.ok(service.getBills(token, page, size, year, month))
    }

    @GetMapping("/confTable")
    fun getBillConf(
        @RequestHeader("Authorization") token: String,
        @RequestParam("year", required = false) year: String?,
        @RequestParam("month", required = false) month: String?
    ): ResponseEntity<ConfTableDto> {
        return ResponseEntity.ok(service.getBillsConf(token, year, month))
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
