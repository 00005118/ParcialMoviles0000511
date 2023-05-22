package com.example.softwaresystemtracker.ui.software.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.softwaresystemtracker.R
import com.example.softwaresystemtracker.data.SoftwareModel
import com.example.softwaresystemtracker.databinding.FragmentCatalogBinding
import com.example.softwaresystemtracker.ui.software.catalog.RecyclerView.SoftwareRecyclerViewAdapter
import com.example.softwaresystemtracker.ui.software.catalog.viewmodel.SoftwareViewModel

class CatalogFragment : Fragment() {

    lateinit var bindingCatalog : FragmentCatalogBinding
    private lateinit var adapter: SoftwareRecyclerViewAdapter
    private val softwareViewModel: SoftwareViewModel by activityViewModels{
        SoftwareViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingCatalog = DataBindingUtil.inflate(inflater,R.layout.fragment_catalog,container,false)
        return bindingCatalog.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView(view)
    }
    private fun setRecycleView(view: View) {
        bindingCatalog.sofwareRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = SoftwareRecyclerViewAdapter { selectedSoftware ->
            showSelectedItem(selectedSoftware)

        }
        bindingCatalog.sofwareRecyclerView.adapter = adapter
        displaySofware()
    }
    private fun showSelectedItem(movie: SoftwareModel){
        softwareViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_catalogFragment_to_newSoftwareFragment)
    }
    private fun displaySofware(){
        adapter.setData(softwareViewModel.getSoftware())
        adapter.notifyDataSetChanged()
    }
}