package com.a548bky4474.intermediatesub.view.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.a548bky4474.intermediatesub.databinding.ActivityRegisterBinding
import com.a548bky4474.intermediatesub.view.ViewModelFactory
import com.a548bky4474.intermediatesub.view.login.LoginActivity

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
        playAnimation()

        viewModel.resultRegister.observe(this) {
            binding.pbRegister.visibility = View.GONE
            var alertDialog: AlertDialog.Builder? = null
            Log.i("ingfo",it.toString())
            if (it.error == true) {
                alertDialog = AlertDialog.Builder(this).apply {
                    setTitle("Oops !")
                    setMessage(it.message)
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
                    setMessage(it.message)
                    setNegativeButton("Lanjut") { dialog, _ ->
                        dialog.cancel()
                        dialog.dismiss()
                    }
                    create()
                }
                alertDialog.show()
            }
        }

        binding.pbRegister.visibility = View.GONE
        binding.btnRegister.setOnClickListener {
            binding.pbRegister.visibility = View.VISIBLE
            viewModel.registerUser(
                binding.tiName.text.toString(),
                binding.tiEmail.text.toString(),
                binding.tiPassword.text.toString()
            )
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
        binding.btnLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.ivRegister, View.TRANSLATION_X, -30f, 30f).apply {
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
            ObjectAnimator.ofFloat(binding.tilPassReg, View.ALPHA, 1f).setDuration(150)
        val nameTextInput =
            ObjectAnimator.ofFloat(binding.tiName, View.ALPHA, 1f).setDuration(150)
        val nameTextInputLayout =
            ObjectAnimator.ofFloat(binding.tilNameReg, View.ALPHA, 1f).setDuration(150)
        val btnLogin =
            ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(150)
        val btnRegister =
            ObjectAnimator.ofFloat(binding.btnRegister, View.ALPHA, 1f).setDuration(150)

        AnimatorSet().apply {
            playSequentially(
                title,
                nameTextInput,
                nameTextInputLayout,
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