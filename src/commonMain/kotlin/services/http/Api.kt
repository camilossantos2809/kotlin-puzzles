package services.http

import io.ktor.client.*
import io.ktor.client.engine.curl.*
import io.ktor.client.plugins.cookies.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import services.env.getEnvVariable


object Api {

    suspend fun getInputByDay(day: Int): String {
        val client = HttpClient(Curl) {
            install(HttpCookies)
        }
        val sessionToken = getEnvVariable("AOC_SESSION_TOKEN") ?: ""
        val response = client.get("https://adventofcode.com/2024/day/$day/input") {
            cookie("session", sessionToken)
        }

        return response.bodyAsText()
    }

}
