package de.p72b.umi.github.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.p72b.umi.github.services.Repository

class DetailsViewModel(repository: Repository) : ViewModel() {

    private val _data = MutableLiveData<Repository>()
    val data: LiveData<Repository>
        get() = _data


    init {
        _data.value = repository
    }
}
