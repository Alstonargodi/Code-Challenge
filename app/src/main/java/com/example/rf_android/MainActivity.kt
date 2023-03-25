package com.example.rf_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rf_android.adapter.MainRecyclerViewAdapter
import com.example.rf_android.databinding.ActivityMainBinding
import com.example.rf_android.entity.dataTest
import com.example.rf_android.supervisedlearning.RandomForest
import com.ml.quaterion.text2summary.Text2Summary
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
            randomForestPrediction()
        }
    }

    private fun randomForestPrediction(){
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
        adapter.detailOnclickCallback(object : MainRecyclerViewAdapter.DetailCallback{
            override fun detailCallBack(data: String) {
                startActivity(Intent(this@MainActivity,DetailActivity::class.java))
            }
        })
    }


    private fun TFIDFcalculate(){
        var text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
        val result = Text2Summary.summarize(text, 0.7F)
        Log.d("summary",result)
        binding.tvresult.text = result
    }
}