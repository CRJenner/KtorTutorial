package com.example.ktortutorial.api

import android.util.Log
import com.example.ktortutorial.model.ExamModel
import com.example.ktortutorial.model.ExamModelReq
import com.example.ktortutorial.model.ExamResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.get
import io.ktor.client.request.url

import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class PostServiceImpl(
    private val client: HttpClient
) :  APIService {
    override suspend fun getCandidateData(): ExamResponse? {
        return try {
            val response = client.get {
                url(HttpRoutes.DETAILS)
                contentType(ContentType.Application.Json)
            }
            val bodyText: String = response.bodyAsText()
            print(bodyText)
            return Json { ignoreUnknownKeys = true }.decodeFromString<ExamResponse>(bodyText)
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            Log.d("Error", e.response.status.description)
            return null
        } catch (e: ClientRequestException) {
            // 4xx - responses
            Log.d("Error", e.response.status.description)
            return null
        } catch (e: ServerResponseException) {
            // 5xx - responses
            Log.d("Error", e.response.status.description)
            return null
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return null
        }
    }
}

