
import com.ml.quaterion.decisiontree.DataFrame
import com.ml.quaterion.decisiontree.RandomForest
import com.ml.quaterion.decisiontree.covid.RandomForestTree
import com.ml.quaterion.decisiontree.covid.TableFrame
import kotlin.collections.ArrayList


fun main( ) {
    val dataFrame = DataFrame()

    //outlook
    dataFrame.addColumn(
        arrayOf(
            "Sunny",
            "Sunny",
            "Overcast",
            "Rain",
            "Rain",
            "Rain",
            "Overcast",
            "Sunny",
            "Sunny",
            "Rain",
            "Sunny",
            "Overcast",
            "Overcast",
            "Rain"
        ).toList() as ArrayList<String>,
        "Outlook"
    )

    //temperature
    dataFrame.addColumn(
        arrayOf(
            "Hot",
            "Hot",
            "Hot",
            "Mild",
            "Cool",
            "Cool",
            "Cool",
            "Mild",
            "Cool",
            "Mild",
            "Mild",
            "Mild",
            "Hot",
            "Mild",
        ).toList() as ArrayList<String>,
        "Temp"
    )

    dataFrame.addColumn(
        arrayOf(
            "High",
            "High",
            "High",
            "High",
            "Normal",
            "Normal",
            "Normal",
            "High",
            "Normal",
            "Normal",
            "Normal",
            "High",
            "Normal",
            "High",
        ).toList() as ArrayList<String>,
        "Humidity"
    )

    dataFrame.addColumn(
        arrayOf(
            "High",
            "High",
            "High",
            "High",
            "Normal",
            "Normal",
            "Normal",
            "High",
            "Normal",
            "Normal",
            "Normal",
            "High",
            "Normal",
            "High",
        ).toList() as ArrayList<String>,
        "Wind"
    )

    dataFrame.addColumn(
        arrayOf(
            "No",
            "No",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "No",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "Yes",
            "No",
        ).toList() as ArrayList<String>,
        "Decision"
    )

    val decisionTree = RandomForest( dataFrame )
    val sample = HashMap<String,String>().apply {
        put( "Outlook" , "Sunny" )
        put( "Temp" , "Hot" )
        put( "Humidity" , "High" )
        put( "Wind" , "Strong" )
        put( "Decision" , "Yes" )
    }

    // Print the tree as a `HashMap`.
//    println( decisionTree.predict( sample ) )
    println( decisionTree )

}