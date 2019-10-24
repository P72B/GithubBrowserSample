package de.p72b.umi.github.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GitHubSearchApi {

    companion object {
        const val SEARCH_ROOT = "search"
    }

    @GET("$SEARCH_ROOT/repositories")
    fun repositories(@Query("q") query: String, @Query("sort") sort: String, @Query("order") order: String): Call<RepositoriesResponse>
}