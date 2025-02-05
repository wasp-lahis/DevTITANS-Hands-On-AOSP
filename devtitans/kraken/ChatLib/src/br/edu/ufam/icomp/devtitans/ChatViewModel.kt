package br.edu.ufam.icomp.devtitans.llminference;

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class ChatViewModel(
    private val inferenceModel: InferenceModel
) {
    private val _uiState: MutableStateFlow<ChatUiState> = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    private val _textInputEnabled: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isTextInputEnabled: StateFlow<Boolean> = _textInputEnabled.asStateFlow()

    // Variável reativa para armazenar e emitir a resposta em tempo real
    private val _lastMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    private val lastMessage: StateFlow<String?> = _lastMessage.asStateFlow()

    suspend fun sendMessage(userMessage: String) {
        // Adiciona a mensagem do usuário ao estado do chat
        _uiState.value.addMessage(userMessage, USER_PREFIX)

        var currentMessageId: String? = _uiState.value.createLoadingMessage()
        setInputEnabled(false)

        try {
            val fullPrompt = _uiState.value.fullPrompt

            // Envia o prompt para o modelo de inferência
            inferenceModel.generateResponseAsync(fullPrompt)

            // Coleta resultados parciais em tempo real
            inferenceModel.partialResults
                .collectIndexed { index, (partialResult, done) ->
                    currentMessageId?.let {
                        if (index == 0) {
                            _uiState.value.appendFirstMessage(it, partialResult)
                        } else {
                            _uiState.value.appendMessage(it, partialResult, done)
                        }

                        // Atualiza a variável _lastMessage com o resultado parcial ou final
                        _lastMessage.value = partialResult

                        if (done) {
                            currentMessageId = null
                            setInputEnabled(true) // Reativa o campo de entrada
                        }
                    }
                }
        } catch (e: Exception) {
            _uiState.value.addMessage(e.localizedMessage ?: "Unknown Error", MODEL_PREFIX)
            _lastMessage.value = "Error: ${e.localizedMessage}" // Emite o erro como mensagem
            setInputEnabled(true)
        }
    }

    // Método que coleta a última mensagem até que o fluxo de resultados seja concluído
    suspend fun getLastMessage(): String? {
        return suspendCancellableCoroutine { continuation ->
            // Coleta o último valor até o fluxo terminar
            runBlocking {
                lastMessage.collect { message ->
                    if (message != null) {
                        continuation.resume(message)
                    }
                }
            }
        }
    }

    private fun setInputEnabled(isEnabled: Boolean) {
        _textInputEnabled.value = isEnabled
    }
}


