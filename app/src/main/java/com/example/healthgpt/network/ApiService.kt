package com.example.healthgpt.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class ChatRequest(val message: String)
data class ChatResponse(val reply: String)

interface ApiService {
    @POST("chat")
    fun sendMessage(@Body req: ChatRequest): Call<ChatResponse>
}
