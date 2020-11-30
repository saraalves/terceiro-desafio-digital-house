package com.example.marvelhq.detalhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.marvelhq.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.*

class ImageFullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_full)

        val image = findViewById<ImageView>(R.id.imageFullscreen)
        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIl_FULL")

        Picasso.get().load(thumbnail).into(image)



        val imgClose = findViewById<ImageView>(R.id.imgClose)
        imgClose.setOnClickListener {
            onBackPressed()
        }
    }
}

