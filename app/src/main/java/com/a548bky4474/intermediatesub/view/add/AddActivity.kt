package com.a548bky4474.intermediatesub.view.add

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.location.LocationManagerCompat
import com.a548bky4474.intermediatesub.R
import com.a548bky4474.intermediatesub.databinding.ActivityAddBinding
import com.a548bky4474.intermediatesub.databinding.ActivityDetailBinding
import com.a548bky4474.intermediatesub.view.ViewModelFactory
import com.a548bky4474.intermediatesub.view.getImageUri
import com.a548bky4474.intermediatesub.view.login.LoginViewModel
import com.a548bky4474.intermediatesub.view.main.MainActivity
import com.a548bky4474.intermediatesub.view.reduceFileImage
import com.a548bky4474.intermediatesub.view.uriToFile
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

class AddActivity : AppCompatActivity() {
    private var currentImageUri: Uri? = null
    private lateinit var binding: ActivityAddBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var myLocation: Location
    private lateinit var locationRequest: LocationRequest
    private val viewModel by viewModels<AddViewModel> {
        ViewModelFactory.getInstance(this)
    }


    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false -> {
                    // Precise location access granted.
                    getMyLastLocation()
                }
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false -> {
                    // Only approximate location access granted.
                    getMyLastLocation()
                }
                else -> {
                    // No location access granted.
                    val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    if (!LocationManagerCompat.isLocationEnabled(locationManager)){
                        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    }

                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbAdd.visibility = View.GONE
        binding.btnGallery.setOnClickListener { startGallery() }
        binding.btnCamera.setOnClickListener { startCamera() }
        binding.btnUpload.setOnClickListener {
            binding.pbAdd.visibility = View.VISIBLE
            uploadImage()
            binding.pbAdd.visibility = View.GONE
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getMyLastLocation()
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }
    }
    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.ivStoryAdd.setImageURI(it)
        }
    }

    private fun uploadImage() {
        currentImageUri?.let { uri ->
            val imageFile = uriToFile(uri, this).reduceFileImage()
            Log.d("Image File", "showImage: ${imageFile.path}")
            val description = binding.tvDeskripsiAdd.text.toString()
            viewModel.uploadImage(imageFile, myLocation, description)
            viewModel.resultUpload.observe(this) { result ->
                var alertDialog: AlertDialog.Builder? = null
                if (result.error == true) {
                    alertDialog = AlertDialog.Builder(this).apply {
                        setTitle("Oops !")
                        setMessage(result.message)
                        setNegativeButton("Lanjut") { dialog, _ ->
                            dialog.cancel()
                            dialog.dismiss()
                        }
                        create()
                    }
                    alertDialog.show()
                } else {
                    alertDialog = AlertDialog.Builder(this).apply {
                        setTitle("Yippi !")
                        setMessage(result.message)
                        setNegativeButton("Lanjut") { dialog, _ ->
                            val i = Intent(this@AddActivity, MainActivity::class.java)
                            startActivity(i)
                        }
                        create()
                    }
                    alertDialog.show()
                }
            }

        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }
    private fun getMyLastLocation() {
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION) &&
            checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    myLocation = location
                    binding.tvLatAdd.text = myLocation.latitude.toString()
                    binding.tvLonAdd.text = myLocation.longitude.toString()
                } else {
                    Log.i("ingfo", "no")

                }
            }
        } else {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

}