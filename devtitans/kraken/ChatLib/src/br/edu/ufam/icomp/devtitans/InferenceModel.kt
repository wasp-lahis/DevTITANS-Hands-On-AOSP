package br.edu.ufam.icomp.devtitans.llminference;

import android.content.Context
import com.google.mediapipe.tasks.genai.llminference.LlmInference
import java.io.File
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import androidx.appcompat.app.AppCompatActivity

class InferenceModel : AppCompatActivity()  {
    private var llmInference: LlmInference
    private val MODEL_PATH = "/data/local/tmp/llm/gemma2-2b-it-gpu-int8.bin"

    private val modelExists: Boolean
        get() = File(MODEL_PATH).exists()

    private val _partialResults = MutableSharedFlow<Pair<String, Boolean>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val partialResults: SharedFlow<Pair<String, Boolean>> = _partialResults.asSharedFlow()

    init {
        if (!modelExists) {
            throw IllegalArgumentException("Model not found at path: $MODEL_PATH")
        }

        val options = LlmInference.LlmInferenceOptions.builder()
            .setModelPath(MODEL_PATH)
            .setMaxTokens(1024)
            .setResultListener { partialResult, done ->
                _partialResults.tryEmit(partialResult to done)
            }
            .build()

        llmInference = LlmInference.createFromOptions(getApplicationContext(), options)
    }

    fun generateResponseAsync(prompt: String) {
        // Add the gemma prompt prefix to trigger the response.
        val gemmaPrompt = prompt + "<start_of_turn>model\n"
        llmInference.generateResponseAsync(gemmaPrompt)
    }

}
