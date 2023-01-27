package com.example.twofragmaps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.OverlayItem


class LocationEntryFragment : Fragment(R.layout.locationentryfrag)
{
    var callback: ((Double, Double) -> Unit)? = null
    val viewModel : TestViewModel by activityViewModels()
    // when the view has been created, add the event listener to the button, so
    // the callback is called when it's clicked
    override fun onViewCreated(v: View, b: Bundle?) {

        val btnGo = v.findViewById(R.id.btnGo) as Button
        val etLat = v.findViewById(R.id.etLat) as EditText
        val etLon = v.findViewById(R.id.etLon) as EditText

        btnGo.setOnClickListener {
            // Invoke the callback, passing it the text in the edit text.
            val lat = etLat.text.toString().toDouble()
            val lon = etLon.text.toString().toDouble()
            callback?.invoke(lon, lat)
            viewModel.addMarker(OverlayItem("poi", "poi", GeoPoint(lat, lon)))
        }
    }
}