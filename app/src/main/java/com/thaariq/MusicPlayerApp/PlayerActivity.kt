package com.thaariq.MusicPlayerApp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.SeekBar
import android.widget.Toast
import com.thaariq.musicplayerapp.R
import kotlinx.android.synthetic.main.activity_player.*
import kotlin.repeat

class PlayerActivity : AppCompatActivity() {
    lateinit var runnable: Runnable
    lateinit var mediaPlayer: MediaPlayer


    //    private var handler = Handler()
    private var totalTime: Int = 0

//    private val mediaPlayer = MediaPlayer.create(this@PlayerActivity, R.raw.alqariah)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        supportActionBar?.hide()

         mediaPlayer = MediaPlayer.create(this, R.raw.alqariah)

        seekbar.progress = 0

        seekbar.max = mediaPlayer.duration

        totalTime = mediaPlayer.duration

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {

                if (changed) {
                    mediaPlayer.seekTo(pos)
                }

            }


            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        }
        )



        // Thread
        Thread(Runnable {
            while (mediaPlayer != null) {
                try {
                    var msg = Message()
                    msg.what = mediaPlayer.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()

        play_btn.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()


                play_btn.setImageResource(R.drawable.ic_baseline_pause)
            } else {
                mediaPlayer.pause()
                play_btn.setImageResource(R.drawable.ic_baseline_play)
            }
        }


        var toggle = true

        like.setOnClickListener {
            if (toggle == true) {
                like.setImageResource(R.drawable.ic_vector)
                toggle = false
            } else {
                like.setImageResource(R.drawable.ic_heart)
                toggle = true
            }
        }

        var Shuf = true

        shuffle.setOnClickListener {
            if (Shuf == true) {
                shuffle.setImageResource(R.drawable.ic_green_shuffle)
                Shuf = false
            } else {
                shuffle.setImageResource(R.drawable.ic_shuffle)
                Shuf = true
            }
        }


        var Reap = true

        repeat.setOnClickListener {
            if (Reap == true) {
                repeat.setImageResource(R.drawable.ic_green_repeat)
                Reap = false
            } else {
                repeat.setImageResource(R.drawable.ic_repeat)
                Reap = true
            }



            runnable = Runnable {
                seekbar.progress = mediaPlayer.currentPosition
                handler.postDelayed(runnable, 1000)
            }

            handler.postDelayed(runnable, 1000)
            mediaPlayer.setOnCompletionListener {
                play_btn.setImageResource(R.drawable.ic_baseline_play)

                seekbar.progress = 0
            }

        }

        back_btn.setOnClickListener {
            onBackPressed()
            mediaPlayer.stop()
            finish()

        }

        fun onBackPress(){
            onBackPressed()
            mediaPlayer.stop()
        }


    }


    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            // Update positionBar
            seekbar.progress = currentPosition

            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            elapsedTimeLabel.text = elapsedTime

            var remainingTime = createTimeLabel(totalTime - currentPosition)
            remainingTimeLabel.text = remainingTime
        }
    }
    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

//    private fun stopPlayer(){
//        if (mediaPlayer != null){
//            mediaPlayer.release()
//            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show()
//        }
//    }

    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer.stop()
    }

}