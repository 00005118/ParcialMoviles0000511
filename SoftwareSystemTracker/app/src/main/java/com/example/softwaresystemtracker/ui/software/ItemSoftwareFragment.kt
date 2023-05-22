package com.example.softwaresystemtracker.ui.software

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.softwaresystemtracker.R
import com.example.softwaresystemtracker.databinding.FragmentItemSoftwareBinding

class ItemSoftwareFragment : Fragment() {
    lateinit var bindingiteSofware : FragmentItemSoftwareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingiteSofware = DataBindingUtil.inflate(inflater,R.layout.fragment_item_software,container,false)
        return bindingiteSofware.root
    }


}