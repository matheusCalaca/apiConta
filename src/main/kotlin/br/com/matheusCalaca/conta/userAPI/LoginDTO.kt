package br.com.matheusCalaca.conta.userAPI

class LoginDTO {

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
