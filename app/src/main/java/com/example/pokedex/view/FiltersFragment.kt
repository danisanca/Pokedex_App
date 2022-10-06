package com.example.pokedex.view


import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFiltersBinding
import com.example.pokedex.service.constants.PokedexConstants
import com.example.pokedex.service.model.FilterModel
import com.example.pokedex.viewmodel.ListPokeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FiltersFragment : BottomSheetDialogFragment(),View.OnClickListener {
   private lateinit var binding: FragmentFiltersBinding
    private val listViewModel: ListPokeViewModel by activityViewModels()

    private val listTypes:MutableList<ImageView> = mutableListOf<ImageView>()
    private val listHeights:MutableList<ImageView> = mutableListOf<ImageView>()
    private val listWeights:MutableList<ImageView> = mutableListOf<ImageView>()
    private var itemHeightSelected:Int? = null
    private var itemWeightSelected:Int? = null
    private var itemTypeSelected:MutableList<Int> = mutableListOf<Int>()
    private var rangeMinSelected:Int? = null
    private var rangeMaxSelected:Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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
        //Events
        binding.imgIcShort.setOnClickListener(this)
        binding.imgIcMedium.setOnClickListener(this)
        binding.imgIcTall.setOnClickListener(this)
        binding.imgIcLightWei.setOnClickListener(this)
        binding.imgIcNormalWei.setOnClickListener(this)
        binding.imgIcHeavyWei.setOnClickListener(this)
        binding.imgIcBug.setOnClickListener(this)
        binding.imgIcDark.setOnClickListener(this)
        binding.imgIcDragon.setOnClickListener(this)
        binding.imgIcElectric.setOnClickListener(this)
        binding.imgIcFairy.setOnClickListener(this)
        binding.imgIcFighting.setOnClickListener(this)
        binding.imgIcFire.setOnClickListener(this)
        binding.imgIcFlying.setOnClickListener(this)
        binding.imgIcGhost.setOnClickListener(this)
        binding.imgIcGrass.setOnClickListener(this)
        binding.imgIcGround.setOnClickListener(this)
        binding.imgIcIce.setOnClickListener(this)
        binding.imgIcNormal.setOnClickListener(this)
        binding.imgIcPoison.setOnClickListener(this)
        binding.imgIcPsychic.setOnClickListener(this)
        binding.imgIcRock.setOnClickListener(this)
        binding.imgIcSteel.setOnClickListener(this)
        binding.imgIcWater.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)
        binding.btnApply.setOnClickListener(this)

    }
    private fun Observers(){
        listViewModel.filterSelected.observe(this, Observer {
            if(it == PokedexConstants.MENUFILTER.FILTERS_OPTION){
                listViewModel.optionsSelectedfilters.observe(this, Observer {
                    if(it.height != null){
                        when(it.height){
                            "short" -> itemHeightSelected = binding.imgIcShort.id
                            "medium" -> itemHeightSelected = binding.imgIcMedium.id
                            "tall" -> itemHeightSelected = binding.imgIcTall.id
                            else -> null
                        }
                    }
                    if(it.weight != null){
                        when (it.weight) {
                            "light" -> itemWeightSelected = binding.imgIcLightWei.id
                            "normal" -> itemWeightSelected = binding.imgIcNormalWei.id
                            "heavy" -> itemWeightSelected = binding.imgIcHeavyWei.id
                            else -> null
                        }
                    }
                    if(it.types.isNotEmpty()){
                        it.types.map{
                            if(it == PokedexConstants.FILTERS.TYPE.BUG){
                                itemTypeSelected.add(binding.imgIcBug.id)
                            }
                            else if(it == PokedexConstants.FILTERS.TYPE.DARK){
                                itemTypeSelected.add(binding.imgIcDark.id)
                            }
                            else if(it == PokedexConstants.FILTERS.TYPE.DRAGON ){
                                itemTypeSelected.add(binding.imgIcDragon.id)
                            }
                            else if(it == PokedexConstants.FILTERS.TYPE.ELECTRIC ){
                                itemTypeSelected.add(binding.imgIcElectric.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.FAIRY ){
                                itemTypeSelected.add(binding.imgIcFairy.id)
                            }
                            else if(it == PokedexConstants.FILTERS.TYPE.FIGHTING){
                                itemTypeSelected.add(binding.imgIcFighting.id)
                            }
                            else if(it == PokedexConstants.FILTERS.TYPE.FIRE){
                                itemTypeSelected.add(binding.imgIcFire.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.FLYING ){
                                itemTypeSelected.add(binding.imgIcFlying.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.GHOST ){
                                itemTypeSelected.add(binding.imgIcGhost.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.GRASS ){
                                itemTypeSelected.add(binding.imgIcGrass.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.GROUND ){
                                itemTypeSelected.add(binding.imgIcGround.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.NORMAL){
                                itemTypeSelected.add( binding.imgIcNormal.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.POISON ){
                                itemTypeSelected.add(binding.imgIcPoison.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.PSYCHIC ){
                                itemTypeSelected.add(binding.imgIcPsychic.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.ROCK ){
                                itemTypeSelected.add(binding.imgIcRock.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.STEEL ){
                                itemTypeSelected.add(binding.imgIcSteel.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.WATER ){
                                itemTypeSelected.add(binding.imgIcWater.id)
                            }
                            else if(it ==PokedexConstants.FILTERS.TYPE.ICE ){
                                itemTypeSelected.add(binding.imgIcIce.id)
                            }
                            else{
                                println("Not Found")
                            }
                        }
                    }

                    binding.rangSliderRangPoke.setValues(it.rangeMin,it.rangeMax)

                    itemHeightSelected?.let { it1 -> changeColorHeight(it1) }
                    itemWeightSelected?.let { it1 -> changeColorWeight(it1) }
                    itemTypeSelected.map {
                        changeColorType(it)
                    }
                })
            }
        })

    }

    private fun applyFilters(){
        var heightValue = ""
        var weighttValue = ""
        var valueRangeMin = 1f
        var valueRangeMax = 817f
        var typeValue:MutableList<String> = mutableListOf()

        valueRangeMin = binding.rangSliderRangPoke.values[0]
        valueRangeMax = binding.rangSliderRangPoke.values[1]




        if(itemHeightSelected != null){
            when(itemHeightSelected){
                binding.imgIcShort.id-> heightValue = "short"
                binding.imgIcMedium.id-> heightValue = "medium"
                binding.imgIcTall.id-> heightValue = "tall"
                else -> null
            }
        }
        if(itemWeightSelected != null){
            when(itemWeightSelected){
                binding.imgIcLightWei.id-> weighttValue = "light"
                binding.imgIcNormalWei.id-> weighttValue = "normal"
                binding.imgIcHeavyWei.id-> weighttValue = "heavy"
                else -> null
            }
        }
        if(itemTypeSelected.isNotEmpty()){
            itemTypeSelected.map{
                if(it == binding.imgIcBug.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.BUG)
                }
                else if(it == binding.imgIcDark.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.DARK)
                }
                else if(it == binding.imgIcDragon.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.DRAGON)
                }
                else if(it == binding.imgIcElectric.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.ELECTRIC)
                }
                else if(it == binding.imgIcFairy.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FAIRY)
                }
                else if(it == binding.imgIcFighting.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FIGHTING)
                }
                else if(it == binding.imgIcFire.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FIRE)
                }
                else if(it == binding.imgIcFlying.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.FLYING)
                }
                else if(it == binding.imgIcGhost.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.GHOST)
                }
                else if(it == binding.imgIcGrass.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.GRASS)
                }
                else if(it == binding.imgIcGround.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.GROUND)
                }
                else if(it == binding.imgIcNormal.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.NORMAL)
                }
                else if(it == binding.imgIcPoison.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.POISON)
                }
                else if(it == binding.imgIcPsychic.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.PSYCHIC)
                }
                else if(it == binding.imgIcRock.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.ROCK)
                }
                else if(it == binding.imgIcSteel.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.STEEL)
                }
                else if(it == binding.imgIcWater.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.WATER)
                }
                else if(it == binding.imgIcIce.id){
                    typeValue.add(PokedexConstants.FILTERS.TYPE.ICE)
                }
                else{
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

    private fun genListTypes(){
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

    private fun genListHeight(){
        listHeights.add(binding.imgIcShort)
        listHeights.add(binding.imgIcMedium)
        listHeights.add(binding.imgIcTall)
    }

    private fun genListWeight(){
        listWeights.add(binding.imgIcLightWei)
        listWeights.add(binding.imgIcNormalWei)
        listWeights.add(binding.imgIcHeavyWei)
    }

    private fun changeColorType(itemId: Int){

       if(itemTypeSelected.contains(itemId)){
               listTypes.map{
                   if(it.id == itemId){
                       it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.backgroudInput) }
                   }
               }
       }

    }

    private fun resetFilter(){
        itemHeightSelected = null
        itemWeightSelected = null
        itemTypeSelected = mutableListOf<Int>()
        rangeMinSelected = null
        rangeMaxSelected = null

        listTypes.map{
            it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
         }
        listHeights.map{
            it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
        }
        listWeights.map{
            it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
        }
        listViewModel.menuResetFilter()
        dismiss()
    }

    private fun changeColorHeight(itemBox:Int){

        listHeights.map {
            if(it.id == itemBox){
                it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.backgroudInput) }

            }else{
                it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
            }
        }
    }

    private fun changeColorWeight(itemBox:Int){

        listWeights.map {
            if(it.id == itemBox){
                it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.backgroudInput) }

            }else{
                it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) }
            }
        }
    }

    override fun onClick(v: View) {
        //Height
        if(v.id == R.id.img_ic_short){
            itemHeightSelected = binding.imgIcShort.id
        }
        if(v.id == R.id.img_ic_medium){
            itemHeightSelected = binding.imgIcMedium.id
        }
        if(v.id == R.id.img_ic_tall){
            itemHeightSelected = binding.imgIcTall.id
        }
        //Weight
        if(v.id == R.id.img_ic_light_wei){
            itemWeightSelected = binding.imgIcLightWei.id
        }
        if(v.id == R.id.img_ic_normal_wei){
            itemWeightSelected = binding.imgIcNormalWei.id
        }
        if(v.id == R.id.img_ic_heavy_wei){
            itemWeightSelected = binding.imgIcHeavyWei.id
        }
        //Types
        if(v.id == R.id.img_ic_bug){
            addListType(binding.imgIcBug.id)
        }
        if(v.id == R.id.img_ic_dark){
            addListType(binding.imgIcDark.id)
        }
        if(v.id == R.id.img_ic_dragon){
            addListType(binding.imgIcDragon.id)
        }
        if(v.id == R.id.img_ic_electric){
            addListType(binding.imgIcElectric.id)
        }
        if(v.id == R.id.img_ic_fairy){
            addListType(binding.imgIcFairy.id)
        }
        if(v.id == R.id.img_ic_fighting){
            addListType(binding.imgIcFighting.id)
        }
        if(v.id == R.id.img_ic_fire){
            addListType(binding.imgIcFire.id)
        }
        if(v.id == R.id.img_ic_flying){
            addListType(binding.imgIcFlying.id)
        }
        if(v.id == R.id.img_ic_ghost){
            addListType(binding.imgIcGhost.id)
        }
        if(v.id == R.id.img_ic_grass){
            addListType(binding.imgIcGrass.id)
        }
        if(v.id == R.id.img_ic_ground){
            addListType(binding.imgIcGround.id)
        }
        if(v.id == R.id.img_ic_ice){
            addListType(binding.imgIcIce.id)
        }
        if(v.id == R.id.img_ic_normal){
            addListType(binding.imgIcNormal.id)
        }
        if(v.id == R.id.img_ic_poison){
            addListType(binding.imgIcPoison.id)
        }
        if(v.id == R.id.img_ic_psychic){
            addListType(binding.imgIcPsychic.id)
        }
        if(v.id == R.id.img_ic_rock){
            addListType(binding.imgIcRock.id)
        }
        if(v.id == R.id.img_ic_steel){
            addListType(binding.imgIcSteel.id)
        }
        if(v.id == R.id.img_ic_water){
            addListType(binding.imgIcWater.id)
        }
        if(v.id == R.id.btn_reset){
            resetFilter()
        }
        if(v.id == R.id.btn_apply){
            applyFilters()
            dismiss()
        }

        itemHeightSelected?.let { changeColorHeight(it) }
        itemWeightSelected?.let { changeColorWeight(it) }
    }

    private fun addListType(itemId:Int){
        if(!itemTypeSelected.contains(itemId)){
            itemTypeSelected.add(itemId)
        }
        changeColorType(itemId)
    }


}