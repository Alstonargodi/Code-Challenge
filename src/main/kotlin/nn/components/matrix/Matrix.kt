package nn.components.matrix

/*
    Array Matrix
    operator
    get matrix
    set Row
 */
class Matrix(
    val m : Int,
    val n : Int,
    private var name : String = "matrix"
) {
    private var data = Array(m){
        DoubleArray(n)
    }

    //ambil row dan data
    fun getRow(i : Int): DoubleArray{
        return data[i]
    }
    fun getData(): Array<DoubleArray>{
        return data
    }
    fun setData(data : Array<DoubleArray>){
        this.data = data
    }

    //get and set matrix
    fun set(i : Int,j : Int,element : Double){
        data[i][j] = element
    }

    fun get(i : Int,j : Int): Double{
        return data[i][j]
    }

    //transpose matrix
    fun transpose(): Matrix{
        val transpose = Matrix(n,m)
        for (i in 0 until m ){
            for(j in 0 until n){
                transpose.set(
                    j,i,
                    data[i][j]
                )
            }
        }
        return transpose
    }

    fun getColoumn(j : Int): DoubleArray{
        assert(j < n)
        val column = DoubleArray(m).mapIndexed{ index, d ->
            data[index][j]
        }
        return column.toDoubleArray()
    }

    // deksripsi
    override fun toString(): String {
        return ("$name ukuran ($m*$n) ${data.contentDeepToString()}")
    }

    operator fun plus(mul : Matrix): Matrix{
        val sum = Matrix(mul.m,mul.n)
        for (i in 0 until mul.m){
            for (j in 0 until mul.n){
                sum.set(
                    i,j,
                    mul.get(i,j) + mul.get(i,j)
                )
            }
        }
        return sum
    }

    operator fun minus(mul: Matrix): Matrix{
        val current = Matrix(mul.m,mul.n)
        for (i in 0 until mul.m){
            for (j in 0 until mul.n){
                current.set(
                    i,j,
                    data[i][j] - mul.get(i,j)
                )
            }
        }
        return current
    }

    operator fun minus(v : Double): Matrix{
        val diffrence = Matrix(m,n)
        for (i in 0 until m){
            for( j in 0 until n){
                diffrence.set(
                    i,j,
                    data[i][j] - v
                )
            }
        }
        return diffrence
    }

    operator fun div(m : Matrix): Matrix{
        val result = Matrix(m.m,m.n)
        for (i in 0 until m.m){
            for (j in 0 until m.n){
                result.set(
                    i,j,
                    data[i][j] / m.get(i,j)
                )
            }
        }
        return result
    }

    operator fun times(m : Matrix): Matrix{
        val product = Matrix(m.m,m.n)
        for (i in 0 until m.n){
            for (j in 0 until m.n){
                product.set(
                    i , j,
                    data[i][j] * m.get(i,j)
                )
            }
        }
        return product
    }

    operator fun times(c : Double): Matrix{
        val product = Matrix(m,n)
        for (i in 0 until m){
            for (j in 0 until n){
                product.set(
                    i,j,
                    data[i][j] * c
                )
            }
        }
        return product
    }
}