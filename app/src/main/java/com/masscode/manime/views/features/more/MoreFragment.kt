package com.masscode.manime.views.features.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.masscode.manime.databinding.FragmentMoreBinding
import com.masscode.manime.utils.gone
import com.masscode.manime.utils.visible
import com.masscode.manime.views.adapter.RecyclerViewGridAdapter
import com.masscode.manime.views.base.viewmodel.ViewModelFactory

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private lateinit var viewModel: MoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[MoreViewModel::class.java]
        val adapterAiring = RecyclerViewGridAdapter { id -> showDetail(id) }
        val data = MoreFragmentArgs.fromBundle(requireArguments()).type

        viewModel.setType(data.type)
        binding.loading.visible()
        viewModel.animeAiring.observe(viewLifecycleOwner, { anime ->
            if (anime != null) {
                adapterAiring.setData(anime)
                binding.loading.gone()
            }
        })

        with(binding.rvAnimeMore) {
            setHasFixedSize(true)
            adapter = adapterAiring
        }
    }

    private fun showDetail(id: Int) {
        this.findNavController()
            .navigate(MoreFragmentDirections.actionMoreFragmentToDetailAnimeFragment(id))
    }
}