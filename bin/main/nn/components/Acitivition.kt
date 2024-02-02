package nn.components

import nn.components.matrix.Matrix

abstract class Acitivition {
    abstract fun call(x : Matrix): Matrix
    abstract fun gradient( x : Matrix): Matrix
}