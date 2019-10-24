package de.p72b.umi.github.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.p72b.umi.github.services.RepositoriesResponse
import de.p72b.umi.github.services.Repository
import de.p72b.umi.github.services.WebService
import de.p72b.umi.github.vo.Resource
import de.p72b.umi.github.vo.Status
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRepository : KoinComponent {
    private val webService: WebService by inject()

    private val data = MutableLiveData<Resource<List<Repository>>>()

    fun allRepositories(query: String): LiveData<Resource<List<Repository>>> {
        webService.repositories(query).enqueue(
            object : Callback<RepositoriesResponse> {
                override fun onResponse(
                    call: Call<RepositoriesResponse>,
                    response: Response<RepositoriesResponse>
                ) {
                    data.value = Resource(Status.SUCCESS, response.body()?.items, null)
                }

                override fun onFailure(call: Call<RepositoriesResponse>, t: Throwable) {
                    data.value = Resource(Status.ERROR, null, t.message) // TODO: improve t.message to be more human readable
                }
            }
        )
        return data
    }
}