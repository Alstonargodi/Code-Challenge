package com.example.rf_android.entity

data class ResultEntropy(
    var maxResult : String,
    var entropyResult : ArrayList<String>,
    var informationGain : ArrayList<Double>
)