package com.example.twofragmaps


import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.fragment.app.Fragment
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MapFragment : Fragment(R.layout.mapfrag) {
    var map1: MapView? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // This line sets the user agent, a requirement to download OSM maps


        Configuration.getInstance()
            .load(activity, PreferenceManager.getDefaultSharedPreferences(activity));

        // map resets itself even though it's already there
        // so we have to reload the last settings
        map1 = view.findViewById(R.id.map1)
        map1?.controller?.setZoom(14.0)
        map1?.controller?.setCenter(GeoPoint(51.05, -0.72))
    }

    fun setPosition(lon: Double, lat: Double, zoom: Double = 14.0) {
        map1?.controller?.setCenter(GeoPoint(lat, lon))
        map1?.controller?.setZoom(zoom)
    }

}