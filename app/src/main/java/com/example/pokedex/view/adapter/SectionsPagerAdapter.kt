package com.example.pokedex.view.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pokedex.R
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.view.AboutFragment
import com.example.pokedex.view.StatusFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager,private val objPoke: PokemonModel) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        if(position == 0){
            return AboutFragment.newInstance(position,objPoke)
        }
        else{
            return StatusFragment.newInstance(position + 1,objPoke)
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}