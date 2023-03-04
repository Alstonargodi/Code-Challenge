package com.ml.quaterion.decisiontree.covid

import com.ml.quaterion.decisiontree.DataFrame
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class TableFrame {

    private var table : HashMap<String,ArrayList<String>> = HashMap()
    private var numRows  = 0

    fun setData(data : HashMap<String,ArrayList<String>>){
        table = data
    }

    fun addColumn(columnData : ArrayList<String>,columnName : String){
        table[columnName] = columnData
        numRows = columnData.size
    }

    fun removeColumn(columnName : String){
        table.remove(columnName)
    }

    fun getNumColumn(): Int{
        return table.size
    }

    fun getNumRows(): Int{
        return numRows
    }

    fun getEntries(indices : IntArray): TableFrame{
        val data = TableFrame()
        table.map { column ->
            val list = ArrayList<String>()
            val values = column.value

            for (index in indices){
                list.add(values[index])
            }

            data.addColumn(list,column.key)
        }
        return data
    }

    override fun toString(): String {
        val string = StringBuilder()
        for((columnName,data) in table){
            string.append( "\n $columnName ${Arrays.toString( data.toTypedArray() )}" )
        }
        return super.toString()
    }

    fun getFeatureColumnNames(): List<String>{
        val pkeys = table.keys.toList()
        return pkeys.filter { it != "Label" }
    }

    fun getData(): HashMap<String,ArrayList<String>>{
        return table
    }
}