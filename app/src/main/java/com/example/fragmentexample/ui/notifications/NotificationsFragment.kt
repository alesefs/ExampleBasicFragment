package com.example.fragmentexample.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexample.MainActivity
import com.example.fragmentexample.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(), FragmentManager.OnBackStackChangedListener {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        (activity as AppCompatActivity).supportActionBar?.show()
        val manager: FragmentManager = requireActivity().supportFragmentManager
        manager.addOnBackStackChangedListener(this)

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBackStackChanged() {
        val manager: FragmentManager = requireActivity().supportFragmentManager
        manager.popBackStack()
    }
}