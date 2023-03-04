package com.example.rf_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rf_android.databinding.ActivityMainBinding
import com.example.rf_android.entity.dataTest
import com.example.rf_android.supervisedlearning.RandomForest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var  decisionTree = RandomForest(dataTest())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerate.setOnClickListener {
            innitPrediciton()
        }
    }

    private fun innitPrediciton(){
        val sample = HashMap<String,String>().apply {
            put( "Outlook" , "Sunny" )
            put( "Temp" , "Cool" )
            put( "Humidity" , "High" )
            put( "Wind" , "Strong" )
            put( "Decision" , "No" )
        }

        // Print the tree as a `HashMap`.
        println( decisionTree.predict(sample) )
        println( decisionTree )
    }
}