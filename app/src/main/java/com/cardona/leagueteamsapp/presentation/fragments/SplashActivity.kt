package com.cardona.leagueteamsapp.presentation.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cardona.leagueteamsapp.R
import com.cardona.leagueteamsapp.presentation.activities.MainActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : AppCompatActivity(), CoroutineScope {

    @Transient
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        launch {
            delay(800)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }


    override fun onStop() {
        job.cancel()
        super.onStop()
    }
}
