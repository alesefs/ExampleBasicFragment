package com.example.fragmentexample.ui.subscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import com.example.fragmentexample.MainActivity
import com.example.fragmentexample.R
import com.example.fragmentexample.databinding.FragmentEletricBinding
import com.example.fragmentexample.databinding.FragmentSubScreenBinding
import com.example.fragmentexample.ui.base.BaseFragment

class SubScreenFragment : Fragment() {

    private var _binding: FragmentSubScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SubScreenViewModel
    private lateinit var textView: TextView

    companion object {
        fun newInstance() = SubScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        textView = binding.textSubscreen

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SubScreenViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
    }

}