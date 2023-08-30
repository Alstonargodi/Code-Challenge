package nn

import nn.components.Acitivition
import nn.components.matrix.Matrix
import nn.components.matrix.MatrixOps

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
    var matrix : Matrix? = null
    var weight : Matrix? = null

    var bias : Matrix = MatrixOps.oneLikeArray(1,units)

    //output layer
    var y : Matrix? = null

    //dense = W X + B
    var theta : Matrix? = null


    //gradients
    var dy_theta : Matrix? = null
    var dthetaDw : Matrix? = null
    var dthetaDx : Matrix? = null





}