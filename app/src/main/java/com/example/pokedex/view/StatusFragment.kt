package com.example.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.databinding.FragmentStatusBinding
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.viewmodel.StatusViewModel


class StatusFragment : Fragment() {

    private lateinit var pageViewModel: StatusViewModel
    private var _binding: FragmentStatusBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pageViewModel = ViewModelProvider(this).get(StatusViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        val root = binding.root


        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private var poke: PokemonModel = PokemonModel()
        @JvmStatic
        fun newInstance(sectionNumber: Int,objPoke:PokemonModel): StatusFragment {

            return StatusFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
                poke = objPoke
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}