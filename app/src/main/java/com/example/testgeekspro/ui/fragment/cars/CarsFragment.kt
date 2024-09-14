package com.example.testgeekspro.ui.fragment.cars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.testgeekspro.R
import com.example.testgeekspro.data.CarsModel
import com.example.testgeekspro.databinding.FragmentCarsBinding
import com.example.testgeekspro.ui.adapter.CarsAdapter
import com.example.testgeekspro.utills.Keys

class CarsFragment : Fragment() {

    private val binding by lazy {
        FragmentCarsBinding.inflate(layoutInflater)
    }

    private val carList = arrayListOf(
        CarsModel(
            "Audi",
            "2007",
            "https://www.autostat.ru/application/includes/blocks/big_photo/images/cache/000/116/597/494654e1-670-0.jpg"
        ),
        CarsModel(
            "BWM",
            "2019",
            "https://carsdb.ru/super/cars/m5_competition_f90-473/photo.jpg"
        ),
        CarsModel(
            "Mercedes",
            "2017",
            "https://image-server.autospot.ru/images/1/1/3/13/1/5/1597548/resize/635x476/1597548.jpg"
        ),
        CarsModel(
            "Rolls-Royce",
            "2003",
            "https://auto.vercity.ru/gallery/img/automobiles/Rolls-Royce/2003%20Rolls-Royce%20Phantom%20(UK)/900x/2003%20Rolls-Royce%20Phantom%20(UK)%20001.jpg"
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvCars.adapter = CarsAdapter(carList, this::onClick)
    }

    private fun onClick(model: CarsModel) {
        findNavController().navigate(R.id.carDetailFragment, bundleOf(Keys.KEYS_FOR_CAR to model))
    }
}