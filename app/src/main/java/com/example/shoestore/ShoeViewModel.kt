package com.example.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel:ViewModel() {
    var shoeList=MutableLiveData<ArrayList<ShoeDetails>>(arrayListOf())
    fun addShoe(shoe:ShoeDetails){
        shoeList.value?.add(shoe)
    }
}