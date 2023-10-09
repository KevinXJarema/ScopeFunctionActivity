package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("getTestDataArray output", getTestDataArray().toString())

        val listOfN = listOf(1.0,2.0,3.0,4.0,5.0)
        Log.d("Average less than median test output", averageLessThanMedian(listOfN).toString())

        val context = applicationContext
        val collection = listOf(2,4,5,6,7)
        val recycledView: View? = null

        val view = getView(2, recycledView, collection, context)
        Log.d("Test for getView output", "View: $view")
    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray() = MutableList(10){Random.nextInt()}.apply {sort()}

    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>) = listOfNumbers.average()< listOfNumbers.sorted().run {
        val center = size/2
        if(center%2==0) (get(center) + get(center-1))/2 else get(center).toDouble()
    }



    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context) =
        (recycledView as? TextView?: TextView(context).apply {
            setPadding(5,10,10,0)
            textSize = 22f
        }).apply { text = collection[position].toString() }



}