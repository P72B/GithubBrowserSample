package de.p72b.umi.github.arch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import de.p72b.umi.github.services.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryViewModel(application: Application) : AndroidViewModel(application), KoinComponent {

    private val repository: RepositoryRepository by inject()

    val allRepositories: LiveData<List<Repository>>

    init {
        allRepositories = repository.allRepositories()
    }
}