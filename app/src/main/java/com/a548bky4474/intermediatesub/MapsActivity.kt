package com.a548bky4474.intermediatesub

import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.data.response.StoryResponse

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.a548bky4474.intermediatesub.databinding.ActivityMapsBinding
import com.a548bky4474.intermediatesub.view.StoryAdapter
import com.a548bky4474.intermediatesub.view.ViewModelFactory
import com.a548bky4474.intermediatesub.view.main.MainViewModel
import com.google.android.gms.maps.model.MapStyleOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var dataStoryWithLocation: StoryResponse
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            dataStoryWithLocation = intent.getParcelableExtra("mapsData", StoryResponse::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            dataStoryWithLocation = intent.getParcelableExtra("mapsData")!!
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true
        // Add a marker in Sydney and move the camera
        val Indonesia = LatLng(-3.1187543109400644, 115.31581867888131)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Indonesia))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Indonesia, 5f))
        setMapStyle()

        dataStoryWithLocation.listStory.forEach { data ->
            val latLng = data.lat?.let { data.lon?.let { it1 -> LatLng(it, it1) } }
            mMap.addMarker(
                MarkerOptions()
                    .position(latLng!!)
                    .title(data.name)
                    .snippet(data.description)
            )
        }
    }

    private fun setMapStyle() {
        try {
            val success =
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
            if (!success) {
                Log.e("kontol", "Style parsing failed.")
            }
        } catch (exception: Resources.NotFoundException) {
            Log.e("kontol", "Can't find style. Error: ", exception)
        }
    }
}