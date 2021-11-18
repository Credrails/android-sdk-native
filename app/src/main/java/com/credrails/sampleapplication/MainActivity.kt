package com.credrails.sampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.credrails.androidsdknative.ToasterMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ToasterMessage.s(
                this,
                "Hello World"
        );

       /* val params = SessionParameters.Builder()
            .setUserReference("user-reference")
            .setEmail("johndoe@gmail.com")
            .setName("John Doe")
            .build();

        val sessionId = SessionsManager.createSession(params);*/

        // sample session Id: 7b2967c1-7d77-4c8c-808f-d74d1e155a4d


    }
}