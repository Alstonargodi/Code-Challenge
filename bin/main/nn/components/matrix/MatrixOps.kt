package nn.components.matrix

import java.util.Random

class MatrixOps {
    companion object{

        private fun dot(x1 : DoubleArray, x2 : DoubleArray): Double{
            return DoubleArray(
                x1.size
            ).mapIndexed { index, d ->
                x1[index] * x2[index]
            }.sum()
        }

        fun zerosLike(p : Matrix): Matrix{
            return Matrix(p.m,p.n)
        }

        fun sqrt(p : Matrix): Matrix{
            val out = Matrix(p.m,p.n)
            for (i in 0 until p.m){
                for (j in 0 until p.n){
                    out.set(
                        i,j,
                        kotlin.math.sqrt(
                            p.get(i,j)
                        )
                    )
                }
            }
            return out
        }

        fun onesLikeMatrix(p : Matrix): Matrix{
            val out = Matrix(p.m,p.n)
            for (i in 0 until p.m){
                for (j in 0 until p.n){
                    out.set(i,j,1.0)
                }
            }
            return out
        }

        fun oneLikeArray(m : Int,n : Int): Matrix{
            val out = Matrix(m,n)
            for (i in 0 until m){
                for (j in 0 until n){
                    out.set(
                        i,j,
                        1.0
                    )
                }
            }
            return out
        }

        fun zerosLike(m : Int,n : Int): Matrix{
            return Matrix(m,n)
        }

        fun exp(mat : Matrix): Matrix{
            for (i in 0 until mat.m){
                for (j in 0 until mat.n){
                    mat.set(
                        i,j,
                        kotlin.math.exp(mat.get(i,j))
                    )
                }
            }
            return mat
        }

        fun sumAlongAxis0(mat : Matrix): Double{
            val sum = DoubleArray(mat.m)
            for (i in 0 until mat.m){
                sum[i] = mat.getData()[i].sum()
            }
            return sum.sum()
        }

        fun maxAlongAxis0(mat : Matrix): Double{
            val max = DoubleArray(mat.m)
            for(i in 0 until mat.m){
                max[i] = max_(mat.getData()[i])
            }
            return max.maxOf { it }
        }

        fun maxAlongAxis1(mat : Matrix): Matrix{
            val max = DoubleArray(mat.m)
            for(i in 0 until mat.m){
                max[i] = max_(mat.getData()[i])
            }
            return Matrix(
                1,mat.m
            ).apply {
                setData(arrayOf(max))
            }
        }

        fun uniform(m : Int, n : Int): Matrix{
            val out = Matrix(m,n)
            for (i in 0 until m){
                for (j in 0 until n){
                    out.set(
                        i,j,
                        Random().nextDouble()
                    )
                }
            }
            return out
        }


        fun constant(m : Int, n : Int, c : Double): Matrix{
            val out = Matrix(m,n)
            for(i in 0 until m){
                for(j in 0 until n ){
                    out.set(i,j,c)
                }
            }
            return out
        }

        fun rand(start : Int,end : Int): Double{
            return (Math.random() * (end-start+1)) + start
        }


        fun ln(x : Matrix): Matrix{
            val out = Matrix(x.m,x.n)
            for (i in 0 until x.m){
                for (j in 0 until x.n){
                    out.set(
                        i,j,
                        kotlin.math.ln(x.get(i,j))
                    )
                }
            }
            return out
        }

        fun dot(mat1 : Matrix, mat2 : Matrix): Matrix{
            if (mat1.n != mat2.m){
                throw RuntimeException(" ukuran tidak sama $mat1 dan $mat2")
            }
            val product = Matrix(mat1.m,mat2.n)
            for (i in 0 until mat1.m){
                for (j in 0 until mat2.n){
                    product.set(
                        i,j,
                        dot(
                            mat1.getRow(i),
                            mat2.getColoumn(j)
                        )
                    )
                }
            }
            return product
        }

        private fun max_(x : DoubleArray): Double{
            return x.maxOf { it }
        }
    }
}