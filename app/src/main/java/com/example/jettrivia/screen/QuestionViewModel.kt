package com.example.jettrivia.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.data.DataOrExpection
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.network.QuestionAPI
import com.example.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor( private val repository: QuestionRepository): ViewModel(){
    val data: MutableState<DataOrExpection<ArrayList<QuestionItem>,
            Boolean,
            Exception>> = mutableStateOf(
                DataOrExpection(null, true, Exception("")) )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestion()
            if(data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }

    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!

    }
}