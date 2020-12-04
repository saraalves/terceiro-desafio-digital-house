package com.example.marvelhq.detalhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.marvelhq.R
import com.squareup.picasso.Picasso

class ImageFullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_full)

        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")
         Picasso.get()
                    .load(thumbnail)
                    .into(findViewById<ImageView>(R.id.imageFullscreen))

        val imgClose = findViewById<ImageView>(R.id.imgClose)
        imgClose.setOnClickListener {
            onBackPressed()
        }
    }
}

