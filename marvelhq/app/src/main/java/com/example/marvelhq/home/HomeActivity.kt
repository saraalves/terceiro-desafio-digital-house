package com.example.marvelhq.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhq.R
import com.example.marvelhq.home.view.adapter.PersonagemAdapter
import com.example.marvelhq.model.ComicsModel

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewGridManager = GridLayoutManager(this, 3)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val viewGridAdapter = adapterPersonagem()

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewGridManager
            adapter = viewGridAdapter
        }

    }

    private fun adapterPersonagem(): PersonagemAdapter {
        val mock = PersonagemAdapter(
            arrayListOf(
                ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                ), ComicsModel(
                    "#96",
                    R.drawable.image_homem_aranha
                )
            )
        )
        return mock
    }
}