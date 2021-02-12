package br.com.matheusCalaca.conta.model.mapper

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.DTO.BillDto
import br.com.matheusCalaca.conta.model.DTO.PaymentDto
import br.com.matheusCalaca.conta.model.Payment
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface MapperPayment {

    @Mappings(
        Mapping(source = "datePayment", target = "datePayment"),
        Mapping(source = "receipt", target = "receipt"),
        Mapping(source = "description", target = "description"),
        Mapping(source = "billId", target = "bill.id"),
        Mapping(source = "paymentMethodID", target = "paymentMethod.id"),
    )
    fun convertToModel(paymentDto: PaymentDto): Payment

}
