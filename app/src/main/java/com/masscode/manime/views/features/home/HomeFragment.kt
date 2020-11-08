package com.masscode.manime.views.features.home

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
        val adapterAiring = HomeAdapter { id -> showDetail(id) }
        val adapterUpcoming = HomeAdapter { id -> showDetail(id) }
        val adapterTV = HomeAdapter { id -> showDetail(id) }

        binding.apply {
            topAiringText.visibility = View.GONE
            upcomingText.visibility = View.GONE
            tvText.visibility = View.GONE
            moreAiring.visibility = View.GONE
            moreUpcoming.visibility = View.GONE
            moreTv.visibility = View.GONE
            progressViewAiring.visibility = View.VISIBLE
            progressViewUpcoming.visibility = View.VISIBLE
            progressViewTv.visibility = View.VISIBLE
        }

        viewModel.apply {
            animeAiring.observe(viewLifecycleOwner, { anime ->
                if (anime != null) {
                    adapterAiring.setData(anime)
                    binding.apply {
                        progressViewAiring.visibility = View.GONE
                        topAiringText.visibility = View.VISIBLE
                        moreAiring.visibility = View.VISIBLE
                    }
                }
            })
            animeUpcoming.observe(viewLifecycleOwner, { anime ->
                if (anime != null) {
                    adapterUpcoming.setData(anime)
                    binding.apply {
                        progressViewUpcoming.visibility = View.GONE
                        upcomingText.visibility = View.VISIBLE
                        moreUpcoming.visibility = View.VISIBLE
                    }
                }
            })
            animeTV.observe(viewLifecycleOwner, { anime ->
                if (anime != null) {
                    adapterTV.setData(anime)
                    binding.apply {
                        progressViewTv.visibility = View.GONE
                        tvText.visibility = View.VISIBLE
                        moreTv.visibility = View.VISIBLE
                    }
                }
            })
        }

        binding.apply {
            rvTopAiring.apply {
                setHasFixedSize(true)
                adapter = adapterAiring
            }
            rvTopUpcoming.apply {
                setHasFixedSize(true)
                adapter = adapterUpcoming
            }
            rvTopTv.apply {
                setHasFixedSize(true)
                adapter = adapterTV
            }
            moreAiring.setOnClickListener { showMore("airing") }
            moreUpcoming.setOnClickListener { showMore("upcoming") }
            moreTv.setOnClickListener { showMore("tv") }
        }
    }

    private fun showDetail(id: Int) {
        this.findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToDetailAnimeFragment(id))
    }

    private fun showMore(type: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMoreFragment(type))
    }
}