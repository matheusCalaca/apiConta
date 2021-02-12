package br.com.matheusCalaca.conta.model.DTO

class ConfTableDto {
     var size: Long = 0

    constructor(size: Long) {
        this.size = size
    }

    override fun toString(): String {
        return "{\"size\"=$size}"
    }

}
