package br.com.matheusCalaca.conta.userAPI.model

class LoginDto {

    var identify: String = "";
    var password: String = "";

    constructor(identify: String, password: String) {
        this.identify = identify
        this.password = password
    }

    override fun toString(): String {
        return "{\"identify\":\"$identify\", \"password\":\"$password\"}"
    }


}
