package com.example.fragmentexample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentexample.MainActivity
import com.example.fragmentexample.R
import com.example.fragmentexample.databinding.FragmentDashboardBinding
import com.example.fragmentexample.ui.eletric.EletricFragment
import com.example.fragmentexample.ui.subscreen.SubScreenFragment


class DashboardFragment : Fragment(), FragmentManager.OnBackStackChangedListener {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val factory = DashboardViewModelFactory(this)
        val dashboardViewModel =
            ViewModelProvider(this, factory).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        (activity as AppCompatActivity).supportActionBar?.show()

        val textView: TextView = binding.textDashboard
        val recycler: RecyclerView = binding.rvMainMenu

//        serve no back button
        val manager: FragmentManager = requireActivity().supportFragmentManager
//        val count = manager.backStackEntryCount
        manager.addOnBackStackChangedListener(this)

        with(dashboardViewModel) {
            text.observe(viewLifecycleOwner) {
                textView.text = it
            }

            button.observe(viewLifecycleOwner) {
                with(recycler) {
                    layoutManager = LinearLayoutManager(
                        this.context,
                        RecyclerView.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)
                    adapter = DashboardButtonAdapter(
                        it, root.rootView.width
                    ) { item ->
                        when {
                            item.title.equals(getString(R.string.title_1), true) -> {
                                val transaction = parentFragmentManager.beginTransaction()
                                with(transaction) {
                                    replace(this@DashboardFragment.id, SubScreenFragment())
                                    remove(DashboardFragment())
                                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                    addToBackStack(null)
                                    commit()
                                }
                            }
                            else -> {
                                Toast.makeText(context, "click in ${item.title}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }

        /*dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        dashboardViewModel.button.observe(viewLifecycleOwner) {
            with(recycler) {
                layoutManager = LinearLayoutManager(
                    this.context,
                    RecyclerView.HORIZONTAL,
                    false
                )
                setHasFixedSize(true)
                adapter = DashboardButtonAdapter(
                    it, root.rootView.width
                )
            }
        }*/

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