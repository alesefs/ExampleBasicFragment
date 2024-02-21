package com.example.fragmentexample.ui.eletric

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexample.MainActivity
import com.example.fragmentexample.R
import com.example.fragmentexample.databinding.FragmentEletricBinding


class EletricFragment : Fragment(), FragmentManager.OnBackStackChangedListener {

    companion object {
        fun newInstance() = EletricFragment()
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private var _binding: FragmentEletricBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EletricViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEletricBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        (activity as AppCompatActivity).supportActionBar?.hide()

        /*val toolbar: Toolbar = binding.toolbar
        activity?.setActionBar(toolbar)
        activity?.actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = getString(R.string.title_eletric)
        }
        toolbar.setNavigationOnClickListener {
            Toast.makeText(
                activity,
                "back pressed",
                Toast.LENGTH_SHORT
            ).show()
            activity?.onBackPressed()
        }*/

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(EletricViewModel::class.java)
        // TODO: Use the ViewModel

        val textView: TextView = binding.textEletric
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val manager: FragmentManager = requireActivity().supportFragmentManager
                val count: Int = manager.backStackEntryCount
                manager.popBackStack()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val manager: FragmentManager = requireActivity().supportFragmentManager
        val count: Int = manager.backStackEntryCount

        Log.i("ALELOG", "$count")
        when (item.itemId) {
            androidx.appcompat.R.id.home -> requireActivity().onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackStackChanged() {
        val manager: FragmentManager = requireActivity().supportFragmentManager
        manager.popBackStack()
    }

//    private fun onBackPressed() {
//        val manager: FragmentManager = requireActivity().supportFragmentManager
//        val count: Int = manager.backStackEntryCount
//        manager.popBackStack()

//        val transaction = parentFragmentManager.beginTransaction()
//        with(transaction) {
//            replace(this@EletricFragment.id, DashboardFragment())
//            remove(EletricFragment())
//            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            addToBackStack(null)
//            commit()
//        }
//    }
}