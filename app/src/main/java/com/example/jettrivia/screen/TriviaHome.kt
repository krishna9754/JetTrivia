package com.example.jettrivia.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.bawp.jettrivia.component.Questions


@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()){
    Questions(viewModel)
}