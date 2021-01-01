package br.com.matheusCalaca.conta.util

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


    fun post(uri: String, body: String, responseType: Class<T>): T? {

        val headers = genericHeaders(null)

        val entity = HttpEntity<String>(body, headers)

        val rest = RestTemplate()

        val response = rest.exchange(uri, HttpMethod.POST, entity, responseType)
        println(response.body)
        return response.body
    }

    fun get(uri: String, queryMap: Map<String, String>, headersMap: Map<String, String>, responseType: Class<T>): T? {
        val headers = genericHeaders(headersMap)

        val entity = HttpEntity<String>(headers)

        return get(uri, queryMap, entity, responseType)
    }

    private fun get(
        uri: String,
        queryMap: Map<String, String>,
        entity: HttpEntity<String>,
        responseType: Class<T>
    ): T? {
        val builder = builderQueryParameter(uri, queryMap)

        val rest = RestTemplate()
        val response = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, responseType)
        println(response.body)
        return response.body
    }

    private fun builderQueryParameter(
        uri: String,
        queryMap: Map<String, String>
    ): UriComponentsBuilder {
        val builder = UriComponentsBuilder.fromHttpUrl(uri)
        for ((key, value) in queryMap) {
            builder.queryParam(key, value)
        }
        return builder
    }


    private fun genericHeaders(headersMap: Map<String, String>?): HttpHeaders {
        val headers = HttpHeaders()
        headers.set("Accept", MediaType.ALL_VALUE)
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        if (headersMap != null) {
            for ((key, value) in headersMap) {
                headers.set(key, value)
            }
        }

        return headers
    }
}
