package com.example.twofragmaps


import android.content.ClipData
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.OverlayItem

class MapFragment : Fragment(R.layout.mapfrag) {
    var map1: MapView? = null

    val viewModel : TestViewModel by activityViewModels()
    lateinit var overlay: ItemizedIconOverlay<OverlayItem>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // This line sets the user agent, a requirement to download OSM maps


        Configuration.getInstance()
            .load(activity, PreferenceManager.getDefaultSharedPreferences(activity));

        // map resets itself even though it's already there
        // so we have to reload the last settings
        map1 = view.findViewById(R.id.map1)
        map1?.controller?.setZoom(14.0)
        map1?.controller?.setCenter(GeoPoint(51.05, -0.72))

        val list = mutableListOf<OverlayItem>()
        overlay = ItemizedIconOverlay<OverlayItem>(activity, list, null)
        map1?.overlays?.add(overlay)
        viewModel.liveMarkers.observe(this.viewLifecycleOwner) {
            Log.d("AAA", "Observed change in ViewModel")
            overlay.removeAllItems()
            overlay.addItems(it)
        }
    }

    fun setPosition(lon: Double, lat: Double, zoom: Double = 14.0) {
        map1?.controller?.setCenter(GeoPoint(lat, lon))
        map1?.controller?.setZoom(zoom)

    }

}