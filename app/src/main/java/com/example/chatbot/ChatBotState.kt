package com.example.chatbot

sealed interface ChatBotUiState {


    data object Ideal : ChatBotUiState
    data object Loading : ChatBotUiState
    data class Success(val ChatData : String) : ChatBotUiState
    data class error(val chatError : String) : ChatBotUiState
}