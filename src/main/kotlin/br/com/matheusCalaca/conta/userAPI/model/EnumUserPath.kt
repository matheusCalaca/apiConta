package br.com.matheusCalaca.conta.userAPI.model

enum class EnumUserPath(var path: String) {
    USERUserPath("/user"),
    USER_LOGINUserPath("/user/login"),
    USER_CPF_TOKEN("/user/token/cpf");


}
