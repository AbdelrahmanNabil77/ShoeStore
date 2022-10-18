package com.example.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.shoestore.R
import com.example.shoestore.model.ShoeDetails
import com.example.shoestore.viewmodel.ShoeViewModel
import com.example.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {
    lateinit var binding:FragmentShoeDetailsBinding
    lateinit var shoeDetails: ShoeDetails
    val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoeDetails= ShoeDetails("","","","")
        binding.shoeDetails=shoeDetails

        binding.btnAddShoe.setOnClickListener {
            shoeDetails=binding.shoeDetails!!
            if(isInputValid()) {
                viewModel.addShoe(shoeDetails)
                requireActivity().onBackPressed()
            }
        }
    }
    private fun isInputValid():Boolean{
        isCategoryValid()
        isBrandValid()
        isDescriptionValid()
        isSizeValid()
        return isCategoryValid()&&isBrandValid()
                &&isDescriptionValid()&&isSizeValid()
    }
    private fun isCategoryValid():Boolean{
        return if (shoeDetails.category.isEmpty()){
            binding.tilCategory.isErrorEnabled=true
            binding.tilCategory.error=requireContext().getText(R.string.category_error_msg)
            false
        }else{
            binding.tilCategory.isErrorEnabled=false
            true
        }
    }

    private fun isDescriptionValid():Boolean{
        return if (shoeDetails.description.isEmpty()){
            binding.tilDescription.isErrorEnabled=true
            binding.tilDescription.error=requireContext().getText(R.string.description_error_msg)
            false
        }else{
            binding.tilDescription.isErrorEnabled=false
            true
        }
    }

    private fun isBrandValid():Boolean{
        return if (shoeDetails.brand.isEmpty()){
            binding.tilBrand.isErrorEnabled=true
            binding.tilBrand.error=requireContext().getText(R.string.brand_error_msg)
            false
        } else{
            binding.tilBrand.isErrorEnabled=false
            true
        }
    }

    private fun isSizeValid():Boolean{
        return if (shoeDetails.shoeSize.isEmpty()){
            binding.tilSize.isErrorEnabled=true
            binding.tilSize.error=requireContext().getText(R.string.size_error_msg)
            false
        }else{
            binding.tilSize.isErrorEnabled=false
            true
        }
    }

}