package com.example.pokedex.presenter


import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFiltersBinding
import com.example.pokedex.service.constants.PokedexConstants
import com.example.pokedex.presenter.model.FilterModel
import com.example.pokedex.presenter.viewmodel.ListPokeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FiltersFragment : BottomSheetDialogFragment(){
    private lateinit var binding: FragmentFiltersBinding
    private val listViewModel: ListPokeViewModel by activityViewModels()

    private val listTypes: MutableList<ImageView> = mutableListOf<ImageView>()
    private val listHeights: MutableList<ImageView> = mutableListOf<ImageView>()
    private val listWeights: MutableList<ImageView> = mutableListOf<ImageView>()
    private var itemHeightSelected: Int? = null
    private var itemWeightSelected: Int? = null
    private var itemTypeSelected: MutableList<Int> = mutableListOf<Int>()
    private var rangeMinSelected: Int? = null
    private var rangeMaxSelected: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiltersBinding.inflate(layoutInflater)
        genListTypes()
        genListHeight()
        genListWeight()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        val layout = binding.bottomSheetLayout
        layout.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
        Observers()

        binding.imgIcShort.setOnClickListener {
            itemHeightSelected = binding.imgIcShort.id
            changeColorHeight(itemHeightSelected)
        }
        binding.imgIcMedium.setOnClickListener {
            itemHeightSelected = binding.imgIcMedium.id
            changeColorHeight(itemHeightSelected)
        }
        binding.imgIcTall.setOnClickListener {
            itemHeightSelected = binding.imgIcTall.id
            changeColorHeight(itemHeightSelected)
        }
        binding.imgIcLightWei.setOnClickListener {
            itemWeightSelected = binding.imgIcLightWei.id
            changeColorWeight(itemWeightSelected)
        }
        binding.imgIcNormalWei.setOnClickListener {
            itemWeightSelected = binding.imgIcNormalWei.id
            changeColorWeight(itemWeightSelected)
        }
        binding.imgIcHeavyWei.setOnClickListener {
            itemWeightSelected = binding.imgIcHeavyWei.id
            changeColorWeight(itemWeightSelected)
        }
        binding.imgIcBug.setOnClickListener {
            addListType(binding.imgIcBug.id)
        }
        binding.imgIcDark.setOnClickListener {
            addListType(binding.imgIcDark.id)
        }
        binding.imgIcDragon.setOnClickListener {
            addListType(binding.imgIcDragon.id)
        }
        binding.imgIcElectric.setOnClickListener {
            addListType(binding.imgIcElectric.id)
        }
        binding.imgIcFairy.setOnClickListener {
            addListType(binding.imgIcFairy.id)
        }
        binding.imgIcFighting.setOnClickListener {
            addListType(binding.imgIcFighting.id)
        }
        binding.imgIcFire.setOnClickListener {
            addListType(binding.imgIcFire.id)
        }
        binding.imgIcFlying.setOnClickListener {
            addListType(binding.imgIcFlying.id)
        }
        binding.imgIcGhost.setOnClickListener {
            addListType(binding.imgIcGhost.id)
        }
        binding.imgIcGrass.setOnClickListener {
            addListType(binding.imgIcGrass.id)
        }
        binding.imgIcGround.setOnClickListener {
            addListType(binding.imgIcGround.id)
        }
        binding.imgIcIce.setOnClickListener {
            addListType(binding.imgIcIce.id)
        }
        binding.imgIcNormal.setOnClickListener {
            addListType(binding.imgIcNormal.id)
        }
        binding.imgIcPoison.setOnClickListener {
            addListType(binding.imgIcPoison.id)
        }
        binding.imgIcPsychic.setOnClickListener {
            addListType(binding.imgIcPsychic.id)
        }
        binding.imgIcRock.setOnClickListener {
            addListType(binding.imgIcRock.id)
        }
        binding.imgIcSteel.setOnClickListener {
            addListType(binding.imgIcSteel.id)
        }
        binding.imgIcWater.setOnClickListener {
            addListType(binding.imgIcWater.id)
        }
        binding.btnReset.setOnClickListener {
            resetFilter()
        }
        binding.btnApply.setOnClickListener {
            applyFilters()
            dismiss()
        }
    }

    private fun Observers() {
        listViewModel.filterSelected.observe(this, Observer {
            if (it == PokedexConstants.MENUFILTER.FILTERS_OPTION) {
                listViewModel.optionsSelectedfilters.observe(this, Observer {
                    if (it.height != null) {
                        when (it.height) {
                            "short" -> itemHeightSelected = binding.imgIcShort.id
                            "medium" -> itemHeightSelected = binding.imgIcMedium.id
                            "tall" -> itemHeightSelected = binding.imgIcTall.id
                            else -> null
                        }
                    }
                    if (it.weight != null) {
                        when (it.weight) {
                            "light" -> itemWeightSelected = binding.imgIcLightWei.id
                            "normal" -> itemWeightSelected = binding.imgIcNormalWei.id
                            "heavy" -> itemWeightSelected = binding.imgIcHeavyWei.id
                            else -> null
                        }
                    }
                    if (it.types.isNotEmpty()) {
                        it.types.map {
                            if (it == PokedexConstants.FILTERS.TYPE.BUG) {
                                itemTypeSelected.add(binding.imgIcBug.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.DARK) {
                                itemTypeSelected.add(binding.imgIcDark.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.DRAGON) {
                                itemTypeSelected.add(binding.imgIcDragon.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.ELECTRIC) {
                                itemTypeSelected.add(binding.imgIcElectric.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.FAIRY) {
                                itemTypeSelected.add(binding.imgIcFairy.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.FIGHTING) {
                                itemTypeSelected.add(binding.imgIcFighting.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.FIRE) {
                                itemTypeSelected.add(binding.imgIcFire.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.FLYING) {
                                itemTypeSelected.add(binding.imgIcFlying.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.GHOST) {
                                itemTypeSelected.add(binding.imgIcGhost.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.GRASS) {
                                itemTypeSelected.add(binding.imgIcGrass.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.GROUND) {
                                itemTypeSelected.add(binding.imgIcGround.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.NORMAL) {
                                itemTypeSelected.add(binding.imgIcNormal.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.POISON) {
                                itemTypeSelected.add(binding.imgIcPoison.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.PSYCHIC) {
                                itemTypeSelected.add(binding.imgIcPsychic.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.ROCK) {
                                itemTypeSelected.add(binding.imgIcRock.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.STEEL) {
                                itemTypeSelected.add(binding.imgIcSteel.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.WATER) {
                                itemTypeSelected.add(binding.imgIcWater.id)
                            } else if (it == PokedexConstants.FILTERS.TYPE.ICE) {
                                itemTypeSelected.add(binding.imgIcIce.id)
                            } else {
                                println("Not Found")
                            }
                        }
                    }
                    binding.rangSliderRangPoke.setValues(it.rangeMin, it.rangeMax)
                    itemHeightSelected?.let { it1 -> changeColorHeight(it1) }
                    itemWeightSelected?.let { it1 -> changeColorWeight(it1) }
                    itemTypeSelected.map {
                        changeColorType(it)
                    }
                })
            }
        })
    }

    private fun applyFilters() {
        var heightValue = ""
        var weighttValue = ""
        var valueRangeMin = 1f
        var valueRangeMax = 817f
        var typeValue: MutableList<String> = mutableListOf()

        valueRangeMin = binding.rangSliderRangPoke.values[0]
        valueRangeMax = binding.rangSliderRangPoke.values[1]

        if (itemHeightSelected != null) {
            when (itemHeightSelected) {
                binding.imgIcShort.id -> heightValue = "short"
                binding.imgIcMedium.id -> heightValue = "medium"
                binding.imgIcTall.id -> heightValue = "tall"
                else -> null
            }
        }
        if (itemWeightSelected != null) {
            when (itemWeightSelected) {
                binding.imgIcLightWei.id -> weighttValue = "light"
                binding.imgIcNormalWei.id -> weighttValue = "normal"
                binding.imgIcHeavyWei.id -> weighttValue = "heavy"
                else -> null
            }
        }
        if (itemTypeSelected.isNotEmpty()) {
            itemTypeSelected.map {
                if (it == binding.imgIcBug.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.BUG)
                } else if (it == binding.imgIcDark.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.DARK)
                } else if (it == binding.imgIcDragon.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.DRAGON)
                } else if (it == binding.imgIcElectric.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.ELECTRIC)
                } else if (it == binding.imgIcFairy.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FAIRY)
                } else if (it == binding.imgIcFighting.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FIGHTING)
                } else if (it == binding.imgIcFire.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FIRE)
                } else if (it == binding.imgIcFlying.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FLYING)
                } else if (it == binding.imgIcGhost.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.GHOST)
                } else if (it == binding.imgIcGrass.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.GRASS)
                } else if (it == binding.imgIcGround.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.GROUND)
                } else if (it == binding.imgIcNormal.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.NORMAL)
                } else if (it == binding.imgIcPoison.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.POISON)
                } else if (it == binding.imgIcPsychic.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.PSYCHIC)
                } else if (it == binding.imgIcRock.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.ROCK)
                } else if (it == binding.imgIcSteel.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.STEEL)
                } else if (it == binding.imgIcWater.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.WATER)
                } else if (it == binding.imgIcIce.id) {
                    typeValue.add(PokedexConstants.FILTERS.TYPE.ICE)
                } else {
                    println("Not Found")
                }
            }
        }

        val filterModel = FilterModel().apply {
            this.height = heightValue
            this.weight = weighttValue
            this.types = typeValue
            this.rangeMin = valueRangeMin
            this.rangeMax = valueRangeMax
        }
        listViewModel.menuFilterSelected(filterModel)
    }

    private fun genListTypes() {
        listTypes.add(binding.imgIcBug)
        listTypes.add(binding.imgIcDark)
        listTypes.add(binding.imgIcDragon)
        listTypes.add(binding.imgIcFairy)
        listTypes.add(binding.imgIcElectric)
        listTypes.add(binding.imgIcFighting)
        listTypes.add(binding.imgIcFire)
        listTypes.add(binding.imgIcFlying)
        listTypes.add(binding.imgIcGhost)
        listTypes.add(binding.imgIcGrass)
        listTypes.add(binding.imgIcGround)
        listTypes.add(binding.imgIcIce)
        listTypes.add(binding.imgIcPoison)
        listTypes.add(binding.imgIcPsychic)
        listTypes.add(binding.imgIcRock)
        listTypes.add(binding.imgIcSteel)
        listTypes.add(binding.imgIcWater)
        listTypes.add(binding.imgIcNormal)
    }

    private fun genListHeight() {
        listHeights.add(binding.imgIcShort)
        listHeights.add(binding.imgIcMedium)
        listHeights.add(binding.imgIcTall)
    }

    private fun genListWeight() {
        listWeights.add(binding.imgIcLightWei)
        listWeights.add(binding.imgIcNormalWei)
        listWeights.add(binding.imgIcHeavyWei)
    }

    private fun changeColorType(itemId: Int) {

        if (itemTypeSelected.contains(itemId)) {
            listTypes.map {
                if (it.id == itemId) {
                    it.backgroundTintList = context?.let { it1 ->
                        ContextCompat.getColorStateList(
                            it1,
                            R.color.backgroudInput
                        )
                    }
                }
            }
        }
    }

    private fun changeColorHeight(itemBox: Int?) {
        if (itemBox != null) {
            listHeights.map {
                if (it.id == itemBox) {
                    it.backgroundTintList = context?.let { it1 ->
                        ContextCompat.getColorStateList(
                            it1,
                            R.color.backgroudInput
                        )
                    }
                } else {
                    it.backgroundTintList =
                        context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
                }
            }
        }
    }

    private fun changeColorWeight(itemBox: Int?) {
        if (itemBox != null) {
            listWeights.map {
                if (it.id == itemBox) {
                    it.backgroundTintList = context?.let { it1 ->
                        ContextCompat.getColorStateList(
                            it1,
                            R.color.backgroudInput
                        )
                    }
                } else {
                    it.backgroundTintList =
                        context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
                }
            }
        }
    }

    private fun resetFilter() {
        itemHeightSelected = null
        itemWeightSelected = null
        itemTypeSelected = mutableListOf<Int>()
        rangeMinSelected = null
        rangeMaxSelected = null

        listTypes.map {
            it.backgroundTintList =
                context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
        }
        listHeights.map {
            it.backgroundTintList =
                context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
        }
        listWeights.map {
            it.backgroundTintList =
                context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
        }
        listViewModel.menuResetFilter()
        dismiss()
    }

    private fun addListType(itemId: Int) {
        if (!itemTypeSelected.contains(itemId)) {
            itemTypeSelected.add(itemId)
        }
        changeColorType(itemId)

    }
}