package nn

import nn.components.Acitivition
import nn.components.matrix.Matrix

class DenseLayer(
    var units : Int,
    var acitivition: Acitivition,
    var requireBias : Boolean = false
){

    /*
        dense = weight matrix + bias
        dense = W X + B
     */
    //input layer
    var X : Matrix? = null
    var W : Matrix? = null


}