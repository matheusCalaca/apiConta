package br.com.matheusCalaca.conta.model.mapper

import br.com.matheusCalaca.conta.model.Bill
import br.com.matheusCalaca.conta.model.DTO.BillDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface MapperBill {

    @Mappings(
        Mapping(source = "maturityDate", target = "maturityDate"),
        Mapping(source = "price", target = "price"),
        Mapping(source = "description", target = "description"),
        Mapping(source = "categoryId", target = "category.id"),
        Mapping(target = "id", ignore = true),
        Mapping(target = "ownerIdentification", ignore = true),
    )
    fun convertToModel(billDto: BillDto): Bill

}
