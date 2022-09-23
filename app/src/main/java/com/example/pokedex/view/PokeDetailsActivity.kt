package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.pokedex.databinding.ActivityPokeDetailsBinding
import com.example.pokedex.view.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class PokeDetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPokeDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarLayout)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tabBar()



    }

    private fun tabBar(){
        println("")
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = SectionsPagerAdapter(this, supportFragmentManager)
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

    }
}