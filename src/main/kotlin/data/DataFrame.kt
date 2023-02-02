package data

class DataFrame {
    private var data: HashMap<String,ArrayList<String>> = HashMap()

    fun setData(x : HashMap<String,ArrayList<String>>){
        data = x
    }

    fun addColoumn(columnData : ArrayList<String>,columnName : String){
        data[columnName] = columnData
    }

    fun removeColumn(columnName: String){
        data.remove(columnName)
    }

    fun getFeaturesColumn(): List<String>{
        val pKeys = data.keys.toList()
        return pKeys.filter { it != "Label"}
    }

    fun getData(): HashMap<String,ArrayList<String>>{
        return data
    }


}