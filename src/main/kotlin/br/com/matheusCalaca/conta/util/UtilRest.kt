package br.com.matheusCalaca.conta.util

import br.com.matheusCalaca.conta.userAPI.LoginDTO
import br.com.matheusCalaca.conta.userAPI.TokenDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder




@Service
class UtilRest<T> {


    @Value("\${userapi.user}")
    private val user: String = ""

    @Value("\${userapi.password}")
    private val senha: String = ""

    fun post(uri: String, body: String, responseType: Class<TokenDTO>): TokenDTO? {

        val headers = genericHeaders()

        val entity = HttpEntity<String>(body, headers)

        val rest = RestTemplate()

        val response = rest.exchange(uri, HttpMethod.POST, entity, responseType)
        println(response.body)
        return response.body
    }

    fun get(uri: String, queryMap: Map<String, String>, responseType: Class<T>): T? {

        val headers = genericHeaders()


        val tokenDTO = post(uri + "/login", LoginDTO(user, senha).toString(), TokenDTO::class.java)
        headers.set("Authorization", "Bearer ${tokenDTO?.token}")

        val builder = UriComponentsBuilder.fromHttpUrl(uri)
        for ((key, value) in queryMap) {
            builder.queryParam(key, value)
        }

        val entity = HttpEntity<String>(headers)

        val rest = RestTemplate()
        val response = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, responseType)
        println(response.body)
        return response.body
    }

    private fun genericHeaders(): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("Accept", MediaType.ALL_VALUE)
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        return headers
    }
}
