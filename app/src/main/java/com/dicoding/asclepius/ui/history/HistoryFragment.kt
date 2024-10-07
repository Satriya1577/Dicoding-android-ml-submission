package com.dicoding.asclepius.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.adapter.HistoryAdapter
import com.dicoding.asclepius.databinding.FragmentHistoryBinding
import com.dicoding.asclepius.utils.NetworkUtils
import com.dicoding.asclepius.viewmodelfactory.ViewModelFactory


class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var historyViewModel: HistoryViewModel
    private var currText: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!NetworkUtils.isInternetAvailable(requireActivity())) {
            showNoInternetDialog()
        }
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        currText = binding.tvTotalPengecekan.text.toString()
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompactActivity = requireActivity() as AppCompatActivity
        historyViewModel = obtainViewModel(appCompactActivity)

        val historyAdapter = HistoryAdapter()
        historyViewModel.listHistory.observe(viewLifecycleOwner) { listHistory ->
            historyAdapter.submitList(listHistory)
            if (listHistory.isEmpty()) {
                binding.tvBelumAdaPengecekan.visibility = View.VISIBLE
                binding.tvTotalPengecekan.visibility = View.INVISIBLE
            } else {
                binding.tvBelumAdaPengecekan.visibility = View.INVISIBLE
                binding.tvTotalPengecekan.visibility = View.VISIBLE
                binding.tvTotalPengecekan.text = "$currText ${listHistory.size} kali"
            }
        }

        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = historyAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        historyViewModel.getAllHistory()
    }


    private fun obtainViewModel(activity: AppCompatActivity): HistoryViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(HistoryViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showNoInternetDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("No internet")
            .setMessage("You are not connected to the internet. Please check your connection and try again.")
            .setPositiveButton("Retry") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}