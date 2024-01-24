package com.example.jettrivia.data

data class DataOrExpection <T, Boolean, E: Exception>(
        var data: T? = null,
        var loading: Boolean? = null,
        var exception: E? = null,
) {

}