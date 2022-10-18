package com.example.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.model.ShoeDetails
import com.example.shoestore.viewmodel.ShoeViewModel
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.databinding.ItemShoeBinding

class ShoeListingFragment : Fragment() {
    lateinit var binding: FragmentShoeListingBinding
    val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        onClickListener()
    }

    private fun onClickListener() {
        binding.fabAddShoe.setOnClickListener {
            val action=
                ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailsFragment()
            findNavController().navigate(action)
        }
    }

    private fun observe(){
        viewModel.shoeList.observe(viewLifecycleOwner,{
                it.forEach {
                    addShoeToLayout(it)
                }
        })
    }

    private fun addShoeToLayout(shoe: ShoeDetails) {
        binding.llShoeList.addView(getShoeView(shoe))
    }

    private fun getShoeView(shoe: ShoeDetails): View {
        val inflater = LayoutInflater.from(requireContext())
        val shoeViewBinding = ItemShoeBinding.inflate(inflater, null, false)
        shoeViewBinding.shoeDetails = shoe
        shoeViewBinding.executePendingBindings()
        return shoeViewBinding.root

    }
}