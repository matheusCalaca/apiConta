package br.com.matheusCalaca.conta.userAPI.service

import br.com.matheusCalaca.conta.userAPI.model.CPFResponseDto

interface UserService {

    fun verifyHasOwner(ownerIdentification: String): Boolean

    fun getUserCpf(token: String): CPFResponseDto?
}
