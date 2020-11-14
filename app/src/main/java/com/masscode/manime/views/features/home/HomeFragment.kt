package com.masscode.manime.views.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.masscode.manime.databinding.FragmentHomeBinding
import com.masscode.manime.utils.gone
import com.masscode.manime.utils.visible
import com.masscode.manime.views.base.viewmodel.ViewModelFactory

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
        setupVisibility()
        observeData()
    }

    private fun setupVisibility() {
        binding.apply {
            topAiringText.gone()
            upcomingText.gone()
            tvText.gone()
            movieText.gone()

            moreAiring.gone()
            moreUpcoming.gone()
            moreTv.gone()
            moreMovie.gone()

            progressViewAiring.visible()
            progressViewUpcoming.visible()
            progressViewTv.visible()
            progressViewMovie.visible()
        }
    }

    private fun observeData() {
        val adapterAiring = HomeAdapter { id -> showDetail(id) }
        val adapterUpcoming = HomeAdapter { id -> showDetail(id) }
        val adapterTV = HomeAdapter { id -> showDetail(id) }
        val adapterMovie = HomeAdapter { id -> showDetail(id) }

        viewModel.apply {
            animeAiring.observe(viewLifecycleOwner, { anime ->
                if (anime.isNotEmpty()) {
                    adapterAiring.setData(anime)
                    binding.apply {
                        progressViewAiring.gone()
                        topAiringText.visible()
                        moreAiring.visible()
                    }
                }
            })
            animeUpcoming.observe(viewLifecycleOwner, { anime ->
                if (anime.isNotEmpty()) {
                    adapterUpcoming.setData(anime)
                    binding.apply {
                        progressViewUpcoming.gone()
                        upcomingText.visible()
                        moreUpcoming.visible()
                    }
                }
            })
            animeTV.observe(viewLifecycleOwner, { anime ->
                if (anime.isNotEmpty()) {
                    adapterTV.setData(anime)
                    binding.apply {
                        progressViewTv.gone()
                        tvText.visible()
                        moreTv.visible()
                    }
                }
            })
            animeMovie.observe(viewLifecycleOwner, { anime ->
                if (anime.isNotEmpty()) {
                    adapterMovie.setData(anime)
                    binding.apply {
                        progressViewMovie.gone()
                        movieText.visible()
                        moreMovie.visible()
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
            rvTopMovie.apply {
                setHasFixedSize(true)
                adapter = adapterMovie
            }
            moreAiring.setOnClickListener { showMore("airing") }
            moreUpcoming.setOnClickListener { showMore("upcoming") }
            moreTv.setOnClickListener { showMore("tv") }
            moreMovie.setOnClickListener { showMore("movie") }
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