package de.p72b.umi.github.services

import com.google.gson.GsonBuilder
import de.p72b.umi.github.utils.Utils
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WebService constructor(config: Configuration) {

    private val api: GitHubSearchApi by lazy {
        val client = OkHttpClient.Builder()
        val gson = GsonBuilder()
            .setDateFormat(Utils.DATE_FORMAT)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(config.apiGitHubSearchServiceUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
        retrofit.build().create(GitHubSearchApi::class.java)
    }

    fun repositories(query: String): Flowable<List<Repository>> {
        return api.repositories(query)
            .map {
                it.items
            }
    }
}