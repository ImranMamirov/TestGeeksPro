package com.example.testgeekspro.ui.fragment.carDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.testgeekspro.R
import com.example.testgeekspro.data.CarsModel
import com.example.testgeekspro.databinding.FragmentCarDetailBinding
import com.example.testgeekspro.utills.Keys

class CarDetailFragment : Fragment() {

    private val binding by lazy {
        FragmentCarDetailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.carsFragment)
        }
    }

    private fun getData() {
        val model = arguments?.getSerializable(Keys.KEYS_FOR_CAR) as CarsModel
        binding.apply {
            tvCarName.text = model.carName
            tvCarYear.text = model.carYear
            imgCars.load(model.carImage)
        }
    }
}