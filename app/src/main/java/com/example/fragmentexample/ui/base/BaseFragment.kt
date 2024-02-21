package com.example.fragmentexample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexample.MainActivity
import com.example.fragmentexample.databinding.FragmentBaseBinding

abstract class BaseFragment : Fragment() {

    companion object {
//        fun newInstance() = BaseFragment()
    }

    private lateinit var viewModel: BaseViewModel

    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    abstract fun provideYourFragmentView(
        inflater: LayoutInflater,
        parent: ViewGroup,
        savedInstanceState: Bundle
    ): View?

    protected fun toolbar(title: String) {
        val toolbarSub: Toolbar = binding.toolbarBase
        (activity as MainActivity).supportActionBar?.hide()
        (activity as MainActivity).setSupportActionBar(toolbarSub)
        (activity as MainActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        toolbarSub.title = title
        toolbarSub.setNavigationOnClickListener {
            Toast.makeText(
                this.context,
                "back pressed",
                Toast.LENGTH_SHORT
            ).show()

            val manager: FragmentManager = requireActivity().supportFragmentManager
            manager.popBackStack()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}