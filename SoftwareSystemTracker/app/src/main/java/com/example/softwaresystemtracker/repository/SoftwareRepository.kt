package com.example.softwaresystemtracker.repository

import com.example.softwaresystemtracker.data.SoftwareModel

class SoftwareRepository (private val software: MutableList<SoftwareModel>) {
    fun getSoftware()=software
    fun addSofware(newMovie: SoftwareModel)= software.add(newMovie)
}