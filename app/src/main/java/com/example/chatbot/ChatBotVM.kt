package com.example.chatbot

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.BuildConfig.apiKey
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch



class ChatBotVM: ViewModel(){
    val list by lazy{
        mutableStateListOf<ChatData>()
    }
    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = ApiKey
        )
    }
         @SuppressLint("SuspiciousIndentation")
         fun sendMessage(message: String) = viewModelScope.launch() {

         val chat = genAI.startChat()

             list.add(ChatData(message,ChatRoleEnum.USER.role))


             chat.sendMessage(
                 content(ChatRoleEnum.USER.role) { text(message)}
                 ).text?.let {
                 list.add(ChatData(it,ChatRoleEnum.MODEL.role))
             }
             }
         }



