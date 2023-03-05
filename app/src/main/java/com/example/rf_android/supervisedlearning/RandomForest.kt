package com.example.rf_android.supervisedlearning

import com.example.rf_android.entity.DataFrame
import kotlin.random.Random

class RandomForest(
    private val data : DataFrame
) {
    private val numTrees = 5
    private val datasetBoostrap = 10
    private var forest : ArrayList<DecissionTree> = ArrayList()
    var informationGainLabel = ArrayList<String>()
    var informationGainResult = ArrayList<Double>()

    init {
        // Create the bootstrapped datasets
        val datasets = createBootstrappedDatasets()
        println( "Bootstrapped datasets created." )
        // Initialize the forest
        createForest( datasets )
    }

    // Predict a class for the given sample using the Random Forest.
    fun predict( x : HashMap<String,String> ) : String {
        // Create an empty array to store class labels.
        val treeOutputs = Array( numTrees ) { "" }
        for ( i in 0 until numTrees ) {
            // Store the output of each DecisionTree in our forest.
            treeOutputs[ i ] = forest[i].predict( x )
            println( "Prediction ${i+1} DecisionTree is ${treeOutputs[i]}")
        }
        // Get the majority label, which is our final prediction for the given sample.
        val mostVotedLabel = treeOutputs.groupingBy{ it }.eachCount().maxByOrNull { entry -> entry.value }!!.key
        println( "Most voted label : $mostVotedLabel" )
        return mostVotedLabel
    }

    // Create bootstrapped datasets given training dataset ( which is given to the constructor of
    // this class ).
    private fun createBootstrappedDatasets() : Array<DataFrame> {
        // ArrayList to store the bootstrapped datasets ( which are DataFrame objects )
        val dataFrames = ArrayList<DataFrame>()
        for ( i in 0 until numTrees ) {
            // Generate N random indices in the range [ 0 , num_samples_in_train_ds ).
            // Here N = BOOTSTRAPPED_DATASET_SIZE
            // Samples at these indices will constitute a bootstrapped dataset.
            val randomIndices = IntArray( datasetBoostrap ){ Random.nextInt( data.getNumRows() ) }
            // Get all the entries ( samples ) present at the given indices and store them in dataFrames.
            dataFrames.add( data.getEntries( randomIndices ) )
        }
        // Return the datasets
        return dataFrames.toTypedArray()
    }

    // Create a forest given the bootstrapped datasets. Each tree will have one bootstrapped dataset.
    private fun createForest( dataFrames : Array<DataFrame> ) {
        for ( i in 0 until numTrees ) {
            // Initialize a DecisionTree with ith bootstrapped dataset. Add to the forest.
            println( "Creating ${i+1} DecisionTree ..." )
            var result = DecissionTree(dataFrames[i])
            informationGainLabel = result.informationGainResult.entropyResult
            informationGainResult = result.informationGainResult.informationGain
            forest.add(result)
        }
    }
}