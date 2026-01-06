package com.example.healthgpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText
import android.widget.ImageButton
import com.example.healthgpt.adapter.ChatAdapter
import com.example.healthgpt.model.Message
import com.example.healthgpt.network.*

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var messageBox: EditText
    private lateinit var sendBtn: ImageButton
    private lateinit var chatRecycler: RecyclerView
    private lateinit var adapter: ChatAdapter
    private val messages = ArrayList<Message>()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://health-gpt-9zpw.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageBox = findViewById(R.id.messageBox)
        sendBtn = findViewById(R.id.sendBtn)
        chatRecycler = findViewById(R.id.chatRecycler)

        adapter = ChatAdapter(messages)
        chatRecycler.layoutManager = LinearLayoutManager(this)
        chatRecycler.adapter = adapter

        sendBtn.setOnClickListener {
            val question = messageBox.text.toString()

            if (question.isNotEmpty()) {
                addMessage(question, true)

                val request = ChatRequest(question)

                api.sendMessage(request).enqueue(object : Callback<ChatResponse> {
                    override fun onResponse(
                        call: Call<ChatResponse>,
                        response: Response<ChatResponse>
                    ) {
                        val reply = response.body()?.reply ?: "No response from server"
                        addMessage(reply, false)
                    }

                    override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                        addMessage("Failed to connect to server", false)
                    }
                })

                messageBox.setText("")
            }
        }
    }

    private fun addMessage(text: String, isUser: Boolean) {
        messages.add(Message(text, isUser))
        adapter.notifyItemInserted(messages.size - 1)
        chatRecycler.scrollToPosition(messages.size - 1)
    }
}
