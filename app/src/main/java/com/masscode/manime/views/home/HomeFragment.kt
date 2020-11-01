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

        binding.topAiringText.visibility = View.GONE
        binding.upcomingText.visibility = View.GONE
        binding.tvText.visibility = View.GONE
        binding.moreAiring.visibility = View.GONE
        binding.moreUpcoming.visibility = View.GONE
        binding.moreTv.visibility = View.GONE

        binding.progressViewAiring.visibility = View.VISIBLE
        binding.progressViewUpcoming.visibility = View.VISIBLE
        binding.progressViewTv.visibility = View.VISIBLE
        viewModel.animeAiring.observe(viewLifecycleOwner, { anime ->
            if (anime != null) {
                adapterAiring.setData(anime)
                binding.progressViewAiring.visibility = View.GONE
                binding.topAiringText.visibility = View.VISIBLE
                binding.moreAiring.visibility = View.VISIBLE
            }
        })
        viewModel.animeUpcoming.observe(viewLifecycleOwner, { anime ->
            if (anime != null) {
                adapterUpcoming.setData(anime)
                binding.progressViewUpcoming.visibility = View.GONE
                binding.upcomingText.visibility = View.VISIBLE
                binding.moreUpcoming.visibility = View.VISIBLE
            }
        })
        viewModel.animeTV.observe(viewLifecycleOwner, { anime ->
            if (anime != null) {
                adapterTV.setData(anime)
                binding.progressViewTv.visibility = View.GONE
                binding.tvText.visibility = View.VISIBLE
                binding.moreTv.visibility = View.VISIBLE
            }
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