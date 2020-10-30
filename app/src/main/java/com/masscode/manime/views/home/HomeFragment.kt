package com.masscode.manime.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.masscode.manime.databinding.FragmentHomeBinding
import com.masscode.manime.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        val adapterAiring = HomeAdapter()
        val adapterUpcoming = HomeAdapter()
        val adapterTV = HomeAdapter()

        viewModel.animeAiring.observe(viewLifecycleOwner, { anime ->
            adapterAiring.setData(anime)
        })
        viewModel.animeUpcoming.observe(viewLifecycleOwner, { anime ->
            adapterUpcoming.setData(anime)
        })
        viewModel.animeTV.observe(viewLifecycleOwner, { anime ->
            adapterTV.setData(anime)
        })

        with(binding.rvTopAiring) {
            setHasFixedSize(true)
            adapter = adapterAiring
        }
        with(binding.rvTopUpcoming) {
            setHasFixedSize(true)
            adapter = adapterUpcoming
        }
        with(binding.rvTopTv) {
            setHasFixedSize(true)
            adapter = adapterTV
        }

        binding.moreAiring.setOnClickListener { showMore("airing") }
        binding.moreUpcoming.setOnClickListener { showMore("upcoming") }
        binding.moreTv.setOnClickListener { showMore("tv") }
    }

    private fun showMore(type: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMoreFragment(type))
    }
}