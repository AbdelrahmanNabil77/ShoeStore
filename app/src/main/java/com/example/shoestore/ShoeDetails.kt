package com.example.shoestore

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData

data class ShoeDetails(
    @Bindable
    var brand:String,
    @Bindable
    var shoeSize:String,
    @Bindable
    var category:String,
    @Bindable
    var description:String
):BaseObservable()
