package de.p72b.umi.github.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.p72b.umi.github.services.Repository

class DetailsViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
