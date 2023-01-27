package com.example.twofragmaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    // in the Activity
    override fun onCreate (savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        AlertDialog.Builder(this).setPositiveButton("OK",null).setMessage("onCreate()").show()
        setContentView (R.layout.activity_main)

        // Find each fragment using their IDs
        val locationEntryFrag = supportFragmentManager.findFragmentById(R.id.locationEntryFrag) as LocationEntryFragment
        val mapFrag = supportFragmentManager.findFragmentById(R.id.mapFrag) as MapFragment?

        locationEntryFrag.callback = { lon, lat ->
            mapFrag?.setPosition(lon, lat)
        }
    }
}