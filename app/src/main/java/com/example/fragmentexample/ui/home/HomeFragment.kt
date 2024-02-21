package com.example.fragmentexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexample.MainActivity
import com.example.fragmentexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), FragmentManager.OnBackStackChangedListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val manager: FragmentManager = requireActivity().supportFragmentManager
        manager.addOnBackStackChangedListener(this)

//        val toolbar3: Toolbar = binding.toolbar3
//        (activity as MainActivity).supportActionBar?.show()
//        (activity as MainActivity).setSupportActionBar(toolbar3)
//        (activity as MainActivity).supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//        }
//        toolbar3.setNavigationOnClickListener {
//            onBackStackChanged()
//        }

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBackStackChanged() {
        Toast.makeText(
            this.context,
            "back pressed",
            Toast.LENGTH_SHORT
        ).show()
    }
}