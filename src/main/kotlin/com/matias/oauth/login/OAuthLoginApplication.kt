package com.matias.oauth.login

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OAuthLoginApplication

fun main(args: Array<String>) {
    runApplication<OAuthLoginApplication>(*args)
}
