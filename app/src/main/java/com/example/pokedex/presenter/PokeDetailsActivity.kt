package com.example.pokedex.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import coil.load
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityPokeDetailsBinding
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.presenter.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson

class PokeDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokeDetailsBinding
    private var objPoke: PokemonModel = PokemonModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)
        extrasIntent()
        configActivity()
        setSupportActionBar(binding.toolbarLayout)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tabBar()

    }

    private fun extrasIntent() {
        val gson = Gson()
        val getIntent = intent.extras
        val data: String? = getIntent?.getString("objPoke")
        objPoke = gson.fromJson(data, PokemonModel::class.java)
    }

    private fun tabBar() {
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = SectionsPagerAdapter(this, supportFragmentManager, objPoke)
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    private fun configActivity() {
        changeNumber(objPoke.id)
        binding.textPokeNameDetails.text = objPoke.name.replaceFirstChar { it.uppercase() }
        binding.imgPokeDetails.load(objPoke.image)
        changeNameType(objPoke.types)
        changeColor(objPoke.types)
    }

    private fun changeNumber(id: Int) {

        if (id < 10) {
            binding.textPokeNumberDetails.text = "#00" + id.toString()
        } else if (id >= 10 && id < 100) {
            binding.textPokeNumberDetails.text = "#0" + id.toString()
        } else {
            binding.textPokeNumberDetails.text = "#" + id.toString()
        }
    }

    fun changeNameType(types: List<String>) {
        val sizeList = types.size

        if (sizeList == 2) {
            binding.typeOneDetails.text = types[0].replaceFirstChar { it.uppercase() }
            binding.typeTwoDetails.text = types[1].replaceFirstChar { it.uppercase() }
        } else {
            binding.typeOneDetails.text = types[0].replaceFirstChar { it.uppercase() }
        }
    }

    fun typeIcon(color: String): Int {
        when (color) {
            "bug" -> return R.drawable.ic_bug
            "dark" -> return R.drawable.ic_dark
            "dragon" -> return R.drawable.ic_dragon
            "electric" -> return R.drawable.ic_electric
            "fairy" -> return R.drawable.ic_fairy
            "fighting" -> return R.drawable.ic_fighting
            "fire" -> return R.drawable.ic_fire
            "flying" -> return R.drawable.ic_flying
            "ghost" -> return R.drawable.ic_ghost
            "grass" -> return R.drawable.ic_grass
            "ground" -> return R.drawable.ic_ground
            "ice" -> return R.drawable.ic_ice
            "normal" -> return R.drawable.ic_normal
            "poison" -> return R.drawable.ic_poison
            "psychic" -> return R.drawable.ic_psychic
            "rock" -> return R.drawable.ic_rock
            "steel" -> return R.drawable.ic_steel
            "water" -> return R.drawable.ic_water
            else -> return R.color.teal_200
        }
    }

    fun changeColor(types: List<String>) {
        val sizeList = types.size
        var colorOne = ""
        var colorTwo = ""

        if (sizeList == 2) {
            colorOne = types[0]
            colorTwo = types[1]
            binding.typeOneDetails.backgroundTintList =
                ContextCompat.getColorStateList(applicationContext, typeColor(colorOne))
            binding.typeTwoDetails.backgroundTintList =
                ContextCompat.getColorStateList(applicationContext, typeColor(colorTwo))
            binding.typeOneDetails.setCompoundDrawablesWithIntrinsicBounds(
                typeIcon(colorOne),
                0,
                0,
                0
            )
            binding.typeTwoDetails.setCompoundDrawablesWithIntrinsicBounds(
                typeIcon(colorTwo),
                0,
                0,
                0
            )
            binding.typeTwoDetails.isVisible = true
        } else {
            colorOne = types[0]
            binding.typeOneDetails.backgroundTintList =
                ContextCompat.getColorStateList(applicationContext, typeColor(colorOne))
            binding.typeOneDetails.setCompoundDrawablesWithIntrinsicBounds(
                typeIcon(colorOne),
                0,
                0,
                0
            )
            binding.typeTwoDetails.isVisible = false
        }
        binding.appBarLayout.backgroundTintList =
            ContextCompat.getColorStateList(applicationContext, backgroundTypeColor(colorOne))
        binding.appbarMenu.backgroundTintList =
            ContextCompat.getColorStateList(applicationContext, backgroundTypeColor(colorOne))
    }

    fun typeColor(color: String): Int {
        when (color) {
            "bug" -> return R.color.typeBug
            "dark" -> return R.color.typeDark
            "dragon" -> return R.color.typeDragon
            "electric" -> return R.color.typeElectric
            "fairy" -> return R.color.typeFairy
            "fighting" -> return R.color.typeFighting
            "fire" -> return R.color.typeFire
            "flying" -> return R.color.typeFlying
            "ghost" -> return R.color.typeGhost
            "grass" -> return R.color.typeGrass
            "ground" -> return R.color.typeGround
            "ice" -> return R.color.typeIce
            "normal" -> return R.color.typeNormal
            "poison" -> return R.color.typePoison
            "psychic" -> return R.color.typePsychic
            "rock" -> return R.color.typeRock
            "steel" -> return R.color.typeSteel
            "water" -> return R.color.typeWater
            else -> return R.color.teal_200
        }
    }

    fun backgroundTypeColor(color: String): Int {
        when (color) {
            "bug" -> return R.color.bkgTypeBug
            "dark" -> return R.color.bkgTypeDark
            "dragon" -> return R.color.bkgTypeDragon
            "electric" -> return R.color.bkgTypeElectric
            "fairy" -> return R.color.bkgTypeFairy
            "fighting" -> return R.color.bkgTypeFighting
            "fire" -> return R.color.bkgTypeFire
            "flying" -> return R.color.bkgTypeFlying
            "ghost" -> return R.color.bkgTypeGhost
            "grass" -> return R.color.bkgTypeGrass
            "ground" -> return R.color.bkgTypeGround
            "ice" -> return R.color.bkgTypeIce
            "normal" -> return R.color.bkgTypeNormal
            "poison" -> return R.color.bkgTypePoison
            "psychic" -> return R.color.bkgTypePsychic
            "rock" -> return R.color.bkgTypeRock
            "steel" -> return R.color.bkgTypeSteel
            "water" -> return R.color.bkgTypeWater
            else -> return R.color.teal_200
        }
    }
}

