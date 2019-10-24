package de.p72b.umi.github.arch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.p72b.umi.github.services.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryViewModel(application: Application) : AndroidViewModel(application), KoinComponent {

    private val repository: RepositoryRepository by inject()

    var allRepositories: LiveData<List<Repository>> get() = repository.allRepositories()

    init {
        allRepositories = MutableLiveData<List<Repository>>()
    }
}