package com.a548bky4474.intermediatesub.view.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.a548bky4474.intermediatesub.R
import com.a548bky4474.intermediatesub.data.response.ListStoryItem
import com.a548bky4474.intermediatesub.databinding.ActivityMainBinding
import com.a548bky4474.intermediatesub.view.StoryAdapter
import com.a548bky4474.intermediatesub.view.ViewModelFactory
import com.a548bky4474.intermediatesub.view.add.AddActivity
import com.a548bky4474.intermediatesub.view.welcome.WelcomeActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) { user ->
            Log.i("ingfo", user.toString())
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            } else {
                setupView()
                setupAction()
                setupRecyclerView()
            }
        }

        binding.fabAdd.setOnClickListener {
            var addIntent = Intent(this, AddActivity::class.java)
            startActivity(addIntent)
        }

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }
    }

    override fun onResume() {
        super.onResume()
        setupRecyclerView()
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun setupRecyclerView() {
        viewModel.getStories()
        viewModel.stories.observe(this) { stories ->
            val adapter = StoryAdapter()
            adapter.submitList(stories.listStory)
            binding.rvStory.adapter = adapter
            val layoutManager = LinearLayoutManager(this)
            binding.rvStory.layoutManager = layoutManager
            val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
            binding.rvStory.addItemDecoration(itemDecoration)
        }
    }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logout -> {
                    viewModel.logout()
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }

}