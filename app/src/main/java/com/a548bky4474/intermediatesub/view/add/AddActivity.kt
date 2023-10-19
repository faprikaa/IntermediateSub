package com.a548bky4474.intermediatesub.view.add

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.a548bky4474.intermediatesub.R
import com.a548bky4474.intermediatesub.databinding.ActivityAddBinding
import com.a548bky4474.intermediatesub.databinding.ActivityDetailBinding
import com.a548bky4474.intermediatesub.view.ViewModelFactory
import com.a548bky4474.intermediatesub.view.getImageUri
import com.a548bky4474.intermediatesub.view.login.LoginViewModel
import com.a548bky4474.intermediatesub.view.reduceFileImage
import com.a548bky4474.intermediatesub.view.uriToFile

class AddActivity : AppCompatActivity() {
    private var currentImageUri: Uri? = null
    private lateinit var binding: ActivityAddBinding
    private val viewModel by viewModels<AddViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGallery.setOnClickListener {  startGallery()}
        binding.btnCamera.setOnClickListener {  startCamera()}
        binding.btnUpload.setOnClickListener { uploadImage() }

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
            viewModel.uploadImage(imageFile, description)
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
                            dialog.cancel()
                            dialog.dismiss()
                        }
                        create()
                    }
                    alertDialog.show()
                }
            }

        }
    }
}