package com.example.ktortutorial.api

import com.example.ktortutorial.model.ExamModel
import com.example.ktortutorial.model.ExamModelReq
import com.example.ktortutorial.model.ExamResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface APIService {

    suspend fun getCandidateData(): ExamResponse?

    companion object {
        fun create(): APIService {
            return PostServiceImpl(
                client = HttpClient(Android) {
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation) {
                        json(Json {
                            ignoreUnknownKeys = true
                            prettyPrint = true
                            isLenient = true
                        })
                    }
                }
            )
        }
    }
}