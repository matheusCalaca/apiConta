package br.com.matheusCalaca.conta.userAPI.service

import br.com.matheusCalaca.conta.userAPI.model.UserDto
import br.com.matheusCalaca.conta.userAPI.model.UserPathEnum
import br.com.matheusCalaca.conta.util.UtilRest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var utilRest: UtilRest<UserDto>

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
        val uri: String = host + UserPathEnum.USER.path;

        val queryParameter = mapOf("cpf" to ownerIdentification)

        val headersMap = mapOf("Authorization" to "Bearer ${tokenService.getToken()}")

        val user = utilRest.get(uri, queryParameter, headersMap, UserDto::class.java);
        return user
    }
}
