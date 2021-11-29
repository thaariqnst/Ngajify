package com.thaariq.MusicPlayerApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.thaariq.musicplayerapp.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        Handler().postDelayed({
            val moveIntent = Intent(this, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        },1500)
    }
}