package com.example.jettrivia.repository

import android.util.Log
import com.example.jettrivia.data.DataOrExpection
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val questionAPi: QuestionAPI
) {
    private val dataOrExpection =
        DataOrExpection<ArrayList<QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestion(): DataOrExpection<ArrayList<QuestionItem>, Boolean, java.lang.Exception> {
        try {
            dataOrExpection.loading = true
            dataOrExpection.data = questionAPi.getAllQuestion()
            if (dataOrExpection.data.toString().isNotEmpty()){
                dataOrExpection.loading = false
            }
        }catch (exception: Exception){
            dataOrExpection.exception = exception
            Log.d("Exc", "getAllQuestion: ${dataOrExpection.exception!!.localizedMessage}")
        }
        return dataOrExpection
    }

}