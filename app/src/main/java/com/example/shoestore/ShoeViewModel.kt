package com.example.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel:ViewModel() {
    private val arrayListShoeList= arrayListOf<ShoeDetails>()
    val shoeLiveData:MutableLiveData<ShoeDetails> = MutableLiveData()
    fun addShoe(shoe:ShoeDetails){
        shoeLiveData.postValue(shoe)
    }
}