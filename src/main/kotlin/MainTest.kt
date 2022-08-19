fun featuredProduct(products: Array<String>): String {
    // Write your code here
    val productList = arrayListOf<String>()
    products.sort()

    var max = 0
    val productMap : MutableMap<String,Int> = hashMapOf()

    products.forEach {
        if (productMap.containsKey(it)){
            productMap[it] = productMap[it]?.plus(1) ?: 1
        }else{
            productMap[it] = 1
        }

        productMap.keys.forEach {
            val amount = productMap[it] ?: 1
            if (amount > max){
                max = amount
            }
        }

        productMap.keys.forEach {
            if (productMap[it] == max){
                productList.add(it)
            }
        }
        productList.sort()
    }

    return productList[productList.size-1]
}