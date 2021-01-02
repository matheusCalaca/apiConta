package br.com.matheusCalaca.conta.model.dto

class HasClientDto {
    lateinit var identify: String

    constructor(identify: String) {
        this.identify = identify
    }

    override fun toString(): String {
        return "{\"identify\"=\"'$identify'\"}"
    }


}
