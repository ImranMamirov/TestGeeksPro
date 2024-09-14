package com.example.testgeekspro.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testgeekspro.data.CarsModel
import com.example.testgeekspro.databinding.ItemCarsBinding

class CarsAdapter(
    private val carList: List<CarsModel>, private val onCLick: (CarsModel) -> Unit
) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCarsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    inner class ViewHolder(private val binding: ItemCarsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CarsModel) = with(binding) {
            tvCarName.text = model.carName
            tvCarYear.text = model.carYear
            imgCars.load(model.carImage)

            itemView.setOnClickListener {
                onCLick(model)
            }
        }
    }
}
