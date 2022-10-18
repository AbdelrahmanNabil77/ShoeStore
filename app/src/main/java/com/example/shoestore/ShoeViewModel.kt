package com.example.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel:ViewModel() {
    val arrayListShoeList= arrayListOf<ShoeDetails>()
    val shoeLiveData:MutableLiveData<ArrayList<ShoeDetails>> = MutableLiveData(arrayListShoeList)
    fun addShoe(shoe:ShoeDetails){
        arrayListShoeList.add(shoe)
    }
}