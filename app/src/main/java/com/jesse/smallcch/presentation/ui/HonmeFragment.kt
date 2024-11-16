package com.jesse.smallcch.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jesse.smallcch.R
import com.jesse.smallcch.data.model.SmallResponseItem
import com.jesse.smallcch.databinding.FragmentHonmeBinding
import com.jesse.smallcch.presentation.SmallViewModel
import com.jesse.smallcch.presentation.adapter.SmallAdapter
import com.jesse.smallcch.presentation.ui.uiStates.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HonmeFragment : Fragment() {
    private var _binding: FragmentHonmeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SmallViewModel by activityViewModels()

    private lateinit var adapter: SmallAdapter
    private var myList = mutableListOf<SmallResponseItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHonmeBinding.inflate(layoutInflater, container, false)

        initRV()
        viewModel.myData.observe(viewLifecycleOwner) {
            myList.clear()
            myList.addAll(it)
            adapter.notifyDataSetChanged()
        }
        return binding.root
    }

    private fun initRV() {
        adapter = SmallAdapter(myList){
            viewModel.lastSelected(it)
           findNavController().navigate(R.id.action_honmeFragment_to_detailFragment)
        }
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}