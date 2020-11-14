package com.masscode.manime.views.features.detail

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.masscode.manime.R
import com.masscode.manime.app.ui.views.features.detail.DetailAnimeFragmentArgs
import com.masscode.manime.data.source.remote.response.detail.CharactersListResponse
import com.masscode.manime.databinding.CharacterDialogBinding
import com.masscode.manime.databinding.FragmentDetailAnimeBinding
import com.masscode.manime.utils.appToast
import com.masscode.manime.views.adapter.CharacterAdapter
import com.masscode.manime.views.adapter.VideoAdapter
import com.masscode.manime.views.adapter.VoiceActorAdapter
import com.masscode.manime.views.base.viewmodel.ViewModelFactory

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
        val id = DetailAnimeFragmentArgs.fromBundle(requireArguments()).id
        val characterAdapter = CharacterAdapter { character -> showDetailCharacter(character) }
        val videosAdapter = VideoAdapter { url -> showVideo(url) }
        val viewModelFactory = ViewModelFactory.getInstance(requireContext())

        viewModel =
            ViewModelProvider(this, viewModelFactory)[DetailAnimeViewModel::class.java].apply {
                setDetailAnime(id)

                anime.observe(viewLifecycleOwner, { anime ->
                    binding.anime = anime
                    anime.genres.let {
                        for (genre in it.indices) {
                            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            params.setMargins(0, 0, 16, 0)
                            val genreTextView = TextView(requireContext()).apply {
                                setBackgroundResource(R.drawable.bg_genres)
                                layoutParams = params
                                setTextColor(Color.parseColor("#ffffff"))
                                text = anime.genres[genre].name
                            }
                            binding.listGenres.addView(genreTextView)
                        }
                    }
                })

                characters.observe(viewLifecycleOwner, { characters ->
                    if (characters.isNotEmpty()) {
                        characterAdapter.setData(characters)
                    }
                })

                videos.observe(viewLifecycleOwner, { videos ->
                    if (videos.isNotEmpty()) {
                        videosAdapter.setData(videos)
                    }
                })
            }

        with(binding) {
            rvCharacters.apply {
                setHasFixedSize(true)
                adapter = characterAdapter
            }
            rvVideos.apply {
                setHasFixedSize(true)
                adapter = videosAdapter
            }
        }
    }

    private fun showDetailCharacter(mCharacter: CharactersListResponse) {
        val mDialogView: CharacterDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.character_dialog,
            null,
            false
        )
        val actorAdater = VoiceActorAdapter()
        actorAdater.setData(mCharacter.voiceActors)
        mDialogView.apply {
            character = mCharacter
            rvActors.apply {
                setHasFixedSize(true)
                adapter = actorAdater
            }
        }

        val builder = AlertDialog.Builder(requireContext())
            .setView(mDialogView.root)
        val dialog = builder.show()

        mDialogView.closeButton.setOnClickListener { dialog.dismiss() }
    }

    private fun showVideo(url: String?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

        try {
            startActivity(intent)
        } catch (t: Throwable) {
            appToast("Ups, slowly!")
        }
    }
}