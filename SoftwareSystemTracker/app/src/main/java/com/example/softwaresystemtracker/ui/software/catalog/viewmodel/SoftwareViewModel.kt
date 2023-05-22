package com.example.softwaresystemtracker.ui.software.catalog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.softwaresystemtracker.data.SoftwareModel
import com.example.softwaresystemtracker.repository.SoftwareRepository
import com.example.softwaresystemtracker.ui.SoftwareReviewerApplication

class SoftwareViewModel(private val repository: SoftwareRepository): ViewModel() {
    var name = MutableLiveData("")
    var service = MutableLiveData("")
    var description = MutableLiveData("")
    var status = MutableLiveData("")

    fun getSoftware()= repository.getSoftware()// llama a repository y le pase la lista
    fun addSoftware(sofware:SoftwareModel)= repository.addSofware(sofware)

    private fun validarData():Boolean{
        when{
            name.value.isNullOrEmpty()->return false
            description.value.isNullOrEmpty()->return false
            service.value.isNullOrEmpty()->return false
        }
        return true
    }
    fun clearData(){
        name.value = ""
        description.value = ""
        service.value = ""
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SoftwareReviewerApplication
                SoftwareViewModel(app.SoftwareRepository)
            }
        }

        const val SOFTWARE_CREATED = "Software created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }
    fun setSelectedMovie(software: SoftwareModel){
        name.value = software.name
        description.value = software.Description
        service.value = software.service
    }
    //CREAR UNA UNA PELICULA
    fun createSofware(){
        if(!validarData()){
            status.value = WRONG_DATA
            return
        }
        val newSoftware = SoftwareModel(
            name.value.toString(),
            description.value.toString(),
            service.value.toString()
        )
        addSoftware(newSoftware)
        status.value = SOFTWARE_CREATED
    }
    ///////////////////////////////////////////////
}