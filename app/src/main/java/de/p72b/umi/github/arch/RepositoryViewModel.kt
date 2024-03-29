package de.p72b.umi.github.arch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.p72b.umi.github.services.Repository
import de.p72b.umi.github.vo.Resource
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryViewModel(application: Application) : AndroidViewModel(application), KoinComponent {

    private val repository: RepositoryRepository by inject()

    var allRepositories: LiveData<Resource<List<Repository>>> = MutableLiveData<Resource<List<Repository>>>()

    fun searchRepositories(query: String): LiveData<Resource<List<Repository>>> {
        allRepositories = repository.allRepositories(query)
        return allRepositories
    }
}