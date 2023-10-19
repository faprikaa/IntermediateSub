package com.a548bky4474.intermediatesub.view.register

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.a548bky4474.intermediatesub.databinding.ActivityRegisterBinding
import com.a548bky4474.intermediatesub.view.ViewModelFactory

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()

        binding.btnRegister.setOnClickListener {
            viewModel.registerUser(
                binding.tiName.text.toString(),
                binding.tiEmail.text.toString(),
                binding.tiPassword.text.toString()
            )
            viewModel.resultRegister.observe(this) {
                var alertDialog: AlertDialog.Builder? = null
                Log.i("ingfo",it.toString())
                if (it.error == true) {
                    alertDialog = AlertDialog.Builder(this).apply {
                        setTitle("Oops !")
                        setMessage(it.message)
                        setNegativeButton("Lanjut") { dialog, _ ->
                            dialog.cancel()
                        }
                        create()
                    }
                    alertDialog.show()
                } else {
                    alertDialog = AlertDialog.Builder(this).apply {
                        setTitle("Yippi !")
                        setMessage(it.message)
                        setNegativeButton("Lanjut") { dialog, _ ->
                            dialog.cancel()
                        }
                        create()
                    }
                    alertDialog.show()
                }
            }
        }
    }

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
        binding.btnRegister.setOnClickListener {
            val email = binding.tiEmail.text.toString()

            AlertDialog.Builder(this).apply {
                setTitle("Yeah!")
                setMessage("Akun dengan $email sudah jadi nih. Yuk, login dan belajar coding.")
                setPositiveButton("Lanjut") { _, _ ->
                    finish()
                }
                create()
                show()
            }
        }
    }
}