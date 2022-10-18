package com.example.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
        binding.fabAddShoe.setOnClickListener {
            val shoe=ShoeDetails("nike","47","sports","agmad wa7ed")
            viewModel.addShoe(shoe)
        }
    }

    private fun observe(){
        viewModel.shoeLiveData.observe(viewLifecycleOwner,{
                addShoeToLayout(it)
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