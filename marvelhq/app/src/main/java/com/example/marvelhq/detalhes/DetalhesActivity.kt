package com.example.marvelhq.detalhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import com.example.marvelhq.R
import com.example.marvelhq.home.viewmodel.ComicsViewModel
import kotlinx.android.synthetic.main.activity_detalhes.view.*

class DetalhesActivity : AppCompatActivity() {

    private lateinit var _viewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        goBack()

        val imgThumbnail = findViewById<ImageView>(R.id.imageMiniDetalhes)
        imgThumbnail.setOnClickListener {
            val intent = Intent(this@DetalhesActivity, ImageFullActivity::class.java)
//            intent.putExtra("IMAGEM", it.imageMiniDetalhes)
            startActivity(intent)
        }
    }

    private fun goBack() {
        val goBackHome = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarDetalhes)
        goBackHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = findViewById<View>(R.id.loading)
        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

}