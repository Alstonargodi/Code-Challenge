package com.example.rf_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rf_android.adapter.MainRecyclerViewAdapter
import com.example.rf_android.databinding.ActivityMainBinding
import com.example.rf_android.entity.dataTest
import com.example.rf_android.supervisedlearning.RandomForest
import java.lang.Error

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var  decisionTree = RandomForest(dataTest())
    private var nameList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameList = decisionTree.informationGainLabel
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
//        println( decisionTree.predict(sample) )
        try {
            var decissionTree = decisionTree

            binding.tvresult.text = decissionTree .predict(sample)
            showEntropy(
                decissionTree.informationGainResult,
                nameList
            )

        }catch (e : Error){
            Log.d("test",e.toString())
        }

    }

    private fun showEntropy(data : ArrayList<Double>,name : List<String>){
        val adapter = MainRecyclerViewAdapter(data,name)
        binding.recviewIG.adapter = adapter
        binding.recviewIG.layoutManager = LinearLayoutManager(this)
    }
}