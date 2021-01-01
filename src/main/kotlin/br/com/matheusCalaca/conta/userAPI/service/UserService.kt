package br.com.matheusCalaca.conta.userAPI.service

interface UserService {

    fun verifyHasOwner(ownerIdentification: String): Boolean
}
