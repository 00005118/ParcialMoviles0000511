package com.example.softwaresystemtracker.ui.software.catalog.RecyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.softwaresystemtracker.data.SoftwareModel
import com.example.softwaresystemtracker.databinding.FragmentItemSoftwareBinding

class SoftwareRecyclerViewHolder (private val binding: FragmentItemSoftwareBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: SoftwareModel, clickListener:(SoftwareModel)->Unit){
        //llamando data del viewModel que tiene esta conectado con el repository

    }
}