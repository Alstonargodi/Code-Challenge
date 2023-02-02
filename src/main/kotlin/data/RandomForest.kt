package data

import jdk.internal.net.http.frame.DataFrame

class RandomForest(private var data : DataFrame) {
    private val NUM_TREES = 5
    private val boostrap_dataset_size = 32
    private var forest : ArrayList<De>
}