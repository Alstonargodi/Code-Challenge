package com.example.rf_android.supervisedlearning

import com.example.rf_android.entity.DataFrame
import com.example.rf_android.entity.ResultEntropy

class DecissionTree(
    private var data : DataFrame
) {
    private val labelName = "Decision"
    var endTree : HashMap<String,Any>? = null
    lateinit var informationGainResult : ResultEntropy

    init {
        endTree = createTree(data,null)
    }

    fun predict ( x : HashMap<String,String> ) : String {
        return predictWithTree( x , endTree!! )
    }

    private fun predictWithTree(
        x : HashMap<String,String>,
        tree : HashMap<String,Any>
    ): String{
        var prediction = ""
        var tree = tree
        for ( key in tree.keys ) {
            val value = x[key]
            val p = tree[key] as HashMap<String, Any>

            if ( p[ value ] is HashMap<*, *> ) {
                tree = p[value] as HashMap<String, Any>
                prediction = predictWithTree(x,tree)
            }
            else {
                if ( p[ value ] == null ) {
                    val k = p.keys.toList()[0]
                    prediction = p[k] as String
                }
                else {
                    prediction = p[value] as String
                }
                break
            }
        }
        return prediction
    }

    private fun createTree(
        data: DataFrame,
        input : HashMap<String,Any>?
    ): HashMap<String,Any>{
        val informationGain = informationGain(data)
        informationGainResult = informationGain
        val highestFeature = informationGain.maxResult
        val attributes = data.getData()[highestFeature]!!.distinct()
        var tree = input
        if ( tree == null ) {
            tree = HashMap()
            tree[highestFeature] = HashMap<String,Any>()
        }

        for ( attribute in attributes ) {
            val subTable = getSubTableFrame(
                data,highestFeature,attribute
            )

            val clValueCountHashmap = uniqueAndReturnCounts(
                subTable[labelName] as ArrayList<String>
            )
            val clValues = clValueCountHashmap.keys.toTypedArray()
            val counts = clValueCountHashmap.values.toIntArray()
            //println( Arrays.toString( subTable[ LABEL_COLUMN_NAME ]?.toTypedArray() ))
            //print( counts )
            if ( counts.count() == 1 ){
                val p = tree[highestFeature] as HashMap<String,Any>
                p[attribute] = clValues[0]
                break
            }
            else {
                val p = tree[highestFeature] as HashMap<String,Any>
                p[attribute] = createTree(
                    getDataFrame(subTable)
                    , null
                )
            }
        }
        return tree
    }

    private fun getDataFrame(
        x : HashMap<String,
        ArrayList<String>>
    ): DataFrame{
        val dataFrame = DataFrame()
        dataFrame.setData(x)
        return dataFrame
    }


    private fun getSubTableFrame(
        data: DataFrame,
        featureName : String,
        featureValue : String
    ) : HashMap< String , ArrayList<String> > {
        val features = data.getData()[ featureName ]!!
        val outputHashmap = HashMap< String , ArrayList<String> >()
        for ( i in 0 until features.count() ) {
            if ( features[ i ] == featureValue ) {
                for ( x in data.getData().iterator() ){
                    val list = outputHashmap[ x.toPair().first ]
                    if ( list == null ) {
                        outputHashmap[ x.toPair().first ] = ArrayList<String>().apply {
                            add( x.toPair().second[ i ] )
                        }
                    }
                    else{
                        list.add( x.toPair().second[ i ] )
                        outputHashmap[ x.toPair().first ] = list
                    }
                }
            }
        }
        return outputHashmap
    }

    private fun informationGain(data : DataFrame): ResultEntropy{
        val featureNames = data.getFeatureColumnNames()
        val informationGain = ArrayList<Double>()
        val names = ArrayList<String>()
        for(name in featureNames){
            val labelEntropy = entropyLabels(data)
            val featureEntropy = entropyFeature(data,name)
            informationGain.add(labelEntropy-featureEntropy)
            names.add(name)
        }
        return ResultEntropy(
            featureNames[argMax(informationGain)],
            names,
            informationGain
        )
    }

    private fun entropyLabels(
        data : DataFrame
    ): Double{
        val labels = data.getData()[labelName]?.toTypedArray()
        val totalLabelsCount = labels?.count()!!.toFloat()
        var entropyResult = 0.0
        for(label in labels.distinct()){
            val labelCounts = labels.count { it == label }.toFloat()
            val p = (labelCounts/totalLabelsCount).toDouble()
            entropyResult += -p * logBase2(p + 1e-19)
        }
        return entropyResult
    }

    private fun entropyFeature(
        data : DataFrame,
        featureColumn : String
    ): Double{
        val labels = data.getData()[labelName]!!.toTypedArray()
        val featureValues = data.getData()[featureColumn]!!.toTypedArray()
        var featureEntropy = 0.0
        for ( featureValue in featureValues.distinct()){
            var entropy = 0.0
            var deCount = 0.0
            for(label in labels.distinct()){
                var numCount = 0.0
                for(i in 0 until featureValues.count()){
                    if (featureValues[i] == featureValue){
                        if (labels[i] == label){
                            numCount += 1
                        }
                    }
                }
                deCount = featureValues.count {
                    it == featureValue
                }.toDouble()
                val p = numCount / (deCount + 1e-19)
                entropy += p * logBase2(p + 1e-19)
            }
            featureEntropy += -(deCount/labels.count()) * entropy
        }
        println("entropy Feature : $featureEntropy")
        return Math.abs(featureEntropy)
    }

    //find average maximum
    private fun argMax( x : ArrayList<Double> ) : Int {
        var y = Double.NEGATIVE_INFINITY
        var index = 0
        for ( i in 0 until x.count() ) {
            if ( x[ i ] > y ){
                y = x[ i ]
                index = i
            }
        }
        return index
    }


    // Gets the number of occurrences ( frequency ) of all the elements.
    private fun uniqueAndReturnCounts(
        x: ArrayList<String>
    ) : HashMap<String,Int> {
        val outputs = HashMap<String,Int>()
        for ( xi in x.distinct() ){
            outputs[ xi ] = x.count{ it == xi }
        }
        return outputs
    }

    override fun toString(): String {
        return endTree.toString()
    }

    private fun logBase2(x : Double): Double{
        return Math.log10(x)/ Math.log10(2.0)
    }
}