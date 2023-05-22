package com.example.softwaresystemtracker.ui.software.catalog.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.softwaresystemtracker.data.SoftwareModel
import com.example.softwaresystemtracker.databinding.FragmentItemSoftwareBinding
import com.example.softwaresystemtracker.ui.software.ItemSoftwareFragment

class SoftwareRecyclerViewAdapter (private val clickListener: (SoftwareModel) -> Unit) : RecyclerView.Adapter<SoftwareRecyclerViewHolder>(){
    private val softwares = ArrayList<SoftwareModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoftwareRecyclerViewHolder {
        val binding = FragmentItemSoftwareBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SoftwareRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return softwares.size
    }

    override fun onBindViewHolder(holder: SoftwareRecyclerViewHolder, position: Int) {
        val software = softwares[position]
        holder.bind(software, clickListener)
    }
    fun setData(softwareList: List<SoftwareModel>){
        softwares.clear() //Limpia la lista para evitar tener elementos repjetido o inecesarios
        softwares.addAll(softwareList)
    }
}