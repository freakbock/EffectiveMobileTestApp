package com.example.presentation.ui.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.presentation.R

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var vkButton: ImageButton
    private lateinit var okButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText = view.findViewById(R.id.email_editText)
        passwordEditText = view.findViewById(R.id.password_editText)
        loginButton = view.findViewById(R.id.login_button)
        vkButton = view.findViewById(R.id.vk_button)
        okButton = view.findViewById(R.id.ok_button)

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Сбрасываем ошибку при изменении текста
                emailEditText.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordEditText.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Подписываемся на ошибки из ViewModel
        viewModel.emailError.observe(viewLifecycleOwner, Observer { error ->
            emailEditText.error = error
        })

        viewModel.passwordError.observe(viewLifecycleOwner, Observer { error ->
            passwordEditText.error = error
        })

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()

            if (viewModel.validate(email, password)) {
                // Переход без реальной проверки логина/пароля
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }

        vkButton.setOnClickListener { openUrl("https://vk.com") }
        okButton.setOnClickListener { openUrl("https://ok.ru") }
    }

    private fun openUrl(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}
