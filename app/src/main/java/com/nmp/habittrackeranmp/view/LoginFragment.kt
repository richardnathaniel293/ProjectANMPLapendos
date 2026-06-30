package com.nmp.habittrackeranmp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nmp.habittrackeranmp.R
import com.nmp.habittrackeranmp.databinding.FragmentLoginBinding
import com.nmp.habittrackeranmp.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text?.toString()?.trim().orEmpty()
            val password = binding.edtPassword.text?.toString().orEmpty()
            viewModel.login(username, password)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            binding.inputUsername.error = null
            binding.inputPassword.error = null

            if (message != null) {
                binding.inputPassword.error = message
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loginSuccess.observe(viewLifecycleOwner) { success ->
            if (success == true) {
                if (findNavController().currentDestination?.id == R.id.loginFragment) {
                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }
            }
        }

        viewModel.checkSession()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}