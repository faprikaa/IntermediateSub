package com.a548bky4474.intermediatesub.view.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
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
        changePBVisibility(false)

        val email = binding.tiEmail.text.toString()
        val password = binding.tiPassword.text.toString()

        viewModel.resultLogin.observe(this) {

            if (it.error == true){
                alertDialog = AlertDialog.Builder(this).apply {
                    setTitle("Oops !")
                    setMessage(it.message)
                    setNegativeButton("Oke") { dialog, _ ->
                        dialog.dismiss()
                        dialog.cancel()
                        alertDialog = null
                    }
                }
                alertDialog?.create()
                alertDialog?.show()
            } else {
                alertDialog = AlertDialog.Builder(this).apply {
                    setTitle("Yippi !")
                    setMessage("Anda berhasil login. Lanjut ke halaman lanjutnya ?")
                    setPositiveButton("Lanjut") { dialog, _ ->
                        dialog.dismiss()
                        dialog.cancel()
                        alertDialog = null
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }
                }
                alertDialog?.create()
                alertDialog?.show()
            }
            viewModel.saveSession(UserModel(email, it.loginResult?.token!!))
        }
        binding.btnLogin.setOnClickListener {
            changePBVisibility(true)
            viewModel.loginUser(email, password)
            changePBVisibility(false)
        }
        binding.btnRegister.setOnClickListener{
            var i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
        playAnimation()
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

    private fun changePBVisibility(active: Boolean){
        binding.pbLogin.visibility = if (active) View.VISIBLE else View.GONE
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.ivLogin, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title =
            ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(150)
        val emailTextInput =
            ObjectAnimator.ofFloat(binding.tiEmail, View.ALPHA, 1f).setDuration(150)
        val emailTextInputLayout =
            ObjectAnimator.ofFloat(binding.tilEmail, View.ALPHA, 1f).setDuration(150)
        val passTextInput =
            ObjectAnimator.ofFloat(binding.tiPassword, View.ALPHA, 1f).setDuration(150)
        val passTextInputLayout =
            ObjectAnimator.ofFloat(binding.tilPassword, View.ALPHA, 1f).setDuration(150)
        val btnLogin =
            ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(150)
        val btnRegister =
            ObjectAnimator.ofFloat(binding.btnRegister, View.ALPHA, 1f).setDuration(150)
//        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                title,
                emailTextInput,
                emailTextInputLayout,
                passTextInput,
                passTextInputLayout,
                btnLogin,
                btnRegister,
            )
            startDelay = 150
        }.start()
    }
}