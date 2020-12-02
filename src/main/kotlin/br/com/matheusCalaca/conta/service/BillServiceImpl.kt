package br.com.matheusCalaca.conta.service

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.repository.BillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class BillServiceImpl : BillService {

    @Autowired
    lateinit var repository: BillRepository


    override fun save(bill: Bill): Bill {
        return repository.save(bill)
    }

    fun findByid(id: Long): Bill{
        return repository.findById(id).get()
    }

    override fun update(id: Long, bill: Bill): Bill {
        val billReturn: Bill = findByid(id)
        bill.id = billReturn.id
        return repository.save(bill)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

}
