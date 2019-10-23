package de.p72b.umi.github.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.p72b.umi.github.services.RepositoriesResponse
import de.p72b.umi.github.services.Repository
import de.p72b.umi.github.services.WebService
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRepository : KoinComponent {
    private val webService: WebService by inject()

    private val data = MutableLiveData<List<Repository>>()

    fun allRepositories(): LiveData<List<Repository>> {
        webService.repositories("kotlin").enqueue(
            object : Callback<RepositoriesResponse> {
                override fun onResponse(
                    call: Call<RepositoriesResponse>,
                    response: Response<RepositoriesResponse>
                ) {
                    data.value = response.body()?.items
                }

                override fun onFailure(call: Call<RepositoriesResponse>, t: Throwable) {
                    // TODO: let's see
                }
            }
        )
        return data
    }
}