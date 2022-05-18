package com.example.a7minworkout

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.a7minworkout.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null
    private var player:MediaPlayer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.flStart?.setOnClickListener{
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)

            try{
                val soundURI= Uri.parse(
                    "android.resource://com.example.a7minworkout/"+R.raw.elena)
                player= MediaPlayer.create(applicationContext, soundURI)
                player?.isLooping=false
                player?.start()
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }

        binding?.flBMI?.setOnClickListener{
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        binding?.flHistory?.setOnClickListener{
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

    }



    override fun onDestroy(){
        super.onDestroy()
        binding=null

        if(player!=null){
            player!!.stop()
        }
    }
}