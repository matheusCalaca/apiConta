package br.com.matheusCalaca.conta.util

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UtilRest<T> {

    fun post(uri: String, body: String,responseType: Class<T>): T? {

        val headers = HttpHeaders()
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE)

        val entity = HttpEntity<String>(body, headers)

        val rest = RestTemplate()

        val response = rest.exchange(uri, HttpMethod.POST, entity, responseType)
        println(response.body)
        return response.body
    }
}
