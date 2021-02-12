package br.com.matheusCalaca.conta.userAPI.service

import br.com.matheusCalaca.conta.userAPI.model.CPFResponseDto
import br.com.matheusCalaca.conta.userAPI.model.EnumUserPath
import br.com.matheusCalaca.conta.userAPI.model.UserDto
import br.com.matheusCalaca.conta.util.UtilRest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var utilRest: UtilRest<UserDto>

    @Autowired
    lateinit var utilRestCPF: UtilRest<CPFResponseDto>

    @Autowired
    lateinit var tokenService: TokenService

    @Value("\${userapi.host}")
    private val host: String? = null


    override fun verifyHasOwner(ownerIdentification: String): Boolean {
        val user = getUser(ownerIdentification)
        println(user)
        if (user == null) {
            return false
        }
        return true
    }

    private fun getUser(ownerIdentification: String): UserDto? {
        val uri: String = host + EnumUserPath.USERUserPath.path

        val queryParameter = mapOf("cpf" to ownerIdentification)

        val headersMap = mapOf("Authorization" to "Bearer ${tokenService.getToken()}")

        val user = utilRest.get(uri, queryParameter, headersMap, UserDto::class.java)
        return user
    }

    override fun getUserCpf(token: String): CPFResponseDto? {
        val uri: String = host + EnumUserPath.USER_CPF_TOKEN.path

        val headersMap = mapOf("Authorization" to "Bearer $token")

        val cpfResponseDto = utilRestCPF.get(uri, null, headersMap, CPFResponseDto::class.java)
        return cpfResponseDto
    }
}
