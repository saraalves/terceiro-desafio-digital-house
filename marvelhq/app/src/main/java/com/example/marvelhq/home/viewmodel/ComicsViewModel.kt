package com.example.marvelhq.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.marvelhq.model.ComicsModel
import com.example.marvelhq.repository.MarvelRepository
import kotlinx.coroutines.Dispatchers.IO

class ComicsViewModel(val _repository: MarvelRepository) : ViewModel() {

    private var _comicsList: List<ComicsModel> = listOf()
    private var _totalPages: Int = 0
    private var _offset: Int = 0
    private var _count: Int = 0

    fun getList() = liveData(IO) {

        val response = _repository.getComics()
        _count = response.data.count
        _totalPages = if(response.data.total != 0) {
            response.data.total / _count
        } else{
            0
        }

        _comicsList = response.data.results
        emit(response.data.results)
        
    }

    fun nextPage() = liveData(IO) {
        if (_offset.plus(_count) <= _totalPages) {
            _offset = _offset.plus(_count)
            val response = _repository.getComics(_offset)
            emit(response.data.results)
        }
    }
    

    class ComicViewModelFactory(private val _repository: MarvelRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicsViewModel(_repository) as T
        }
    }
}