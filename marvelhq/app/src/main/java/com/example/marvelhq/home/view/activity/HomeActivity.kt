package com.example.marvelhq.home.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhq.R
import com.example.marvelhq.detalhes.DetalhesActivity
import com.example.marvelhq.home.view.adapter.PersonagemAdapter
import com.example.marvelhq.home.viewmodel.ComicsViewModel
import com.example.marvelhq.model.ComicsModel
import com.example.marvelhq.repository.MarvelRepository

class HomeActivity : AppCompatActivity() {

    private lateinit var _viewModel: ComicsViewModel
    private lateinit var _view: View
    private lateinit var _listAdapter: PersonagemAdapter
    private lateinit var _recyclerView: RecyclerView
    private var _comics = mutableListOf<ComicsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewGridManager = GridLayoutManager(this, 3)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        _comics = mutableListOf<ComicsModel>()
        _listAdapter = PersonagemAdapter(_comics) {
            val intent = Intent(this@HomeActivity, DetalhesActivity::class.java)
            intent.putExtra("COMICS_ID", it.id)
            intent.putExtra("COMICS_DESCRIPTION", it.descricao)
            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewGridManager
            adapter = _listAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            ComicsViewModel.ComicViewModelFactory(MarvelRepository())
        ).get(ComicsViewModel::class.java)

        _viewModel.getList().observe({ lifecycle }, {
            _comics.addAll(it)
            _listAdapter.notifyDataSetChanged()
        })
    }

}
