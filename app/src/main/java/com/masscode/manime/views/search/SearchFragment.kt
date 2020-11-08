package com.masscode.manime.views.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.masscode.manime.R
import com.masscode.manime.databinding.FragmentSearchBinding
import com.masscode.manime.viewmodel.ViewModelFactory
import com.masscode.manime.views.season.SeasonAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel
    private lateinit var adapterResult: SeasonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
        adapterResult = SeasonAdapter { id -> showDetail(id) }
        with(binding.rvAnimeSearch) {
            setHasFixedSize(true)
            adapter = adapterResult
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("SetTextI18n")
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.loading.visibility = View.VISIBLE
                binding.welcomeView.visibility = View.GONE
                if (query != null) {
                    viewModel.setResult(query)
                    viewModel.animeResult.observe(viewLifecycleOwner, { anime ->
                        if (anime.isNotEmpty()) {
                            adapterResult.setData(anime)
                            binding.loading.visibility = View.GONE
                        } else {
                            binding.welcomeView.visibility = View.VISIBLE
                            binding.textOnSearch.text =
                                "Ups, no anime found! Try to type another name :)"
                        }
                    })
                }
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun showDetail(id: Int) {
        findNavController().navigate(SearchFragmentDirections.actionSearchToDetailAnimeFragment(id))
    }
}