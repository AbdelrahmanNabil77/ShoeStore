package com.example.shoestore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.ShoeDetails

class ShoeViewModel:ViewModel() {
    var shoeList=MutableLiveData<ArrayList<ShoeDetails>>(arrayListOf())
    fun addShoe(shoe: ShoeDetails){
        shoeList.value?.add(shoe)
    }
}