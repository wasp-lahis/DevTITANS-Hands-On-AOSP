package br.edu.ufam.icomp.devtitans;

import android.util.Log;
import br.edu.ufam.icomp.devtitans.hellojavalib.*;
import br.edu.ufam.icomp.devtitans.llminference.*;
import android.content.Context;
import com.google.mediapipe.tasks.genai.llminference.LlmInference;

class HelloJava  {
    public static final String TAG = "DevTITANS.HelloJava";

    void printHello(Context context) {
        System.out.println("Hello World in Java!");
        Log.v(TAG, "Hello World in Java (LogCat)!");

        final String MODEL_PATH = "/data/local/tmp/llm/gemma-2b-it-cpu-int8.bin";

        //HelloJavaLib helloLib = new HelloJavaLib();
        //System.out.println("Pi value from Lib: " + helloLib.computePiValue());

        LlmInference.LlmInferenceOptions options = LlmInference.LlmInferenceOptions.builder()
            .setModelPath(MODEL_PATH)
            .setMaxTokens(1024)
            .build();

        LlmInference llmInference = LlmInference.createFromOptions(context, options);
        String msg = "hi";
        String res = llmInference.generateResponse(msg);
        System.out.println(res);


        //ChatViewModel chat = new ChatViewModel(inference);
        //String msg = "<start_of_turn>" + "Hi" + "<end_of_turn>";
        //chat.sendMessage(msg);
        //System.out.println(chat.getLastMessage());

    }

    public static void main(String args[]) {
        HelloJava hello = new HelloJava();
        hello.printHello();
    }
}