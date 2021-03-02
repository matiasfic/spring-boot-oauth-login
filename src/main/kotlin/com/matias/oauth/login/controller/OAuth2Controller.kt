package com.matias.oauth.login.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OAuth2Controller {

    @GetMapping("/api/hello")
    suspend fun user(@AuthenticationPrincipal user: OAuth2User): String {
        return "Welcome, " + user.name + "!"
    }

    @GetMapping("/api/userinfo")
    suspend fun userInfo(@AuthenticationPrincipal user: OAuth2User): UserInfo {
        return UserInfo(user.getAttribute("email")!!)
    }

    /**
     * Only for OIDC providers (Google in this example)
     */
    @GetMapping("/api/openid")
    suspend fun openId(@AuthenticationPrincipal user: OidcUser): String {
        return "Welcome, " + user.fullName + "!"
    }
}

data class UserInfo(val email: String)