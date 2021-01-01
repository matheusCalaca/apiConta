package br.com.matheusCalaca.conta.userAPI.service

import br.com.matheusCalaca.conta.userAPI.model.LoginDto
import br.com.matheusCalaca.conta.userAPI.model.TokenDto
import br.com.matheusCalaca.conta.userAPI.model.UserDto
import br.com.matheusCalaca.conta.util.UtilRest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TokenServiceImpl: TokenService {

    @Value("\${userapi.user}")
    private val user: String = ""

    @Value("\${userapi.password}")
    private val senha: String = ""

    @Value("\${userapi.host}")
    private val host: String? = null

    @Autowired
    lateinit var utilRest: UtilRest<TokenDto>


    override fun getToken(): String? {
        val uri: String = host + "/user/login";

        val tokenDTO = utilRest.post(uri, LoginDto(user, senha).toString(), TokenDto::class.java)
        return tokenDTO?.token
    }
}
