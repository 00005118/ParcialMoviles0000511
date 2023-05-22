package com.example.softwaresystemtracker.ui

import android.app.Application
import com.example.softwaresystemtracker.data.softwareList
import com.example.softwaresystemtracker.repository.SoftwareRepository

class SoftwareReviewerApplication:Application() {
    val SoftwareRepository: SoftwareRepository by lazy {
        SoftwareRepository(softwareList) //llena data de repository
    }
}