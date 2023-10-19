package com.a548bky4474.intermediatesub.view.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.a548bky4474.intermediatesub.data.pref.UserModel
import com.a548bky4474.intermediatesub.databinding.ActivityLoginBinding
import com.a548bky4474.intermediatesub.view.ViewModelFactory
import com.a548bky4474.intermediatesub.view.main.MainActivity
import com.a548bky4474.intermediatesub.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityLoginBinding
    private var alertDialog: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        binding.btnLogin.setOnClickListener {
            val email = binding.tiEmail.text.toString()
            val password = binding.tiPassword.text.toString()
            viewModel.loginUser(email, password)
            viewModel.resultLogin.observe(this) {
                if (it.error == true){
                    alertDialog = AlertDialog.Builder(this).apply {
                        setTitle("Oops !")
                        setMessage(it.message)
                        setNegativeButton("Lanjut") { dialog, _ ->
                            dialog.dismiss()
                        }
                    }
                    alertDialog?.create()
                    alertDialog?.show()
                } else {
                    alertDialog = AlertDialog.Builder(this).apply {
                        setTitle("Yeah!")
                        setMessage("Anda berhasil login. Sudah tidak sabar untuk belajar ya?")
                        setPositiveButton("Lanjut") { dialog, _ ->
                            dialog.dismiss()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()

                        }
                    }
                    alertDialog?.create()
                    alertDialog?.show()
                    viewModel.saveSession(UserModel(email, it.loginResult?.token!!))
                }

            }
//            viewModel.saveSession(UserModel(email, "sample_token"))

        }
        binding.btnRegister.setOnClickListener{
            var i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        alertDialog = null
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


}