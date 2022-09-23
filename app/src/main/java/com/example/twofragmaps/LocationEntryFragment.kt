package com.example.twofragmaps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class LocationEntryFragment : Fragment(R.layout.locationentryfrag)
{
    var callback: ((Double, Double) -> Unit)? = null

    // when the view has been created, add the event listener to the button, so
    // the callback is called when it's clicked
    override fun onViewCreated(v: View, b: Bundle?) {

        val btnGo = v.findViewById(R.id.btnGo) as Button
        val etLat = v.findViewById(R.id.etLat) as EditText
        val etLon = v.findViewById(R.id.etLon) as EditText

        btnGo.setOnClickListener {
            // Invoke the callback, passing it the text in the edit text.

            callback?.invoke(etLon.text.toString().toDouble(), etLat.text.toString().toDouble())
        }
    }
}