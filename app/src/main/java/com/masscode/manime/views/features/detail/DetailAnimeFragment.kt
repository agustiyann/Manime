package com.masscode.manime.views.features.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.masscode.manime.R
import com.masscode.manime.databinding.FragmentDetailAnimeBinding
import com.masscode.manime.viewmodel.ViewModelFactory

class DetailAnimeFragment : Fragment() {

    private lateinit var binding: FragmentDetailAnimeBinding
    private lateinit var viewModel: DetailAnimeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailAnimeViewModel::class.java]
        val id = DetailAnimeFragmentArgs.fromBundle(requireArguments()).id

        viewModel.setDetailAnime(id)
        viewModel.anime.observe(viewLifecycleOwner, { anime ->
            binding.anime = anime
            anime.genres.let {
                for (genre in it.indices) {
                    val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 0, 16, 0)
                    val genreTextView = TextView(requireContext())
                    genreTextView.setBackgroundResource(R.drawable.bg_genres)
                    genreTextView.layoutParams = params
                    genreTextView.setTextColor(Color.parseColor("#ffffff"))
                    genreTextView.text = anime.genres[genre].name
                    binding.listGenres.addView(genreTextView)
                }
            }
        })
    }
}