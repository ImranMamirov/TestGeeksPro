package com.example.testgeekspro.data

import java.io.Serializable

data class CarsModel(
    val carName: String,
    val carYear: String,
    val carImage: String
) : Serializable
