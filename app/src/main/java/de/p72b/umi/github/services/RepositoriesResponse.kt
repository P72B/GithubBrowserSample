package de.p72b.umi.github.services

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class RepositoriesResponse(
    @SerializedName("total_count") val totalCount: Int? = null,
    @SerializedName("incomplete_results") val incompleteResults: Boolean? = null,
    @SerializedName("items") val items: List<Repository>? = null
)

// in case of lint error see here https://youtrack.jetbrains.com/issue/KT-19300
@Parcelize
data class Repository(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("node_id") val nodeId: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("full_name") val fullName: String? = null,
    @SerializedName("owner") val owner: Owner? = null,
    @SerializedName("private") val private: Boolean? = null,
    @SerializedName("html_url") val htmlUrl: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("fork") val fork: Boolean? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null,
    @SerializedName("pushed_at") val pushedAt: String? = null,
    @SerializedName("homepage") val homepage: String? = null,
    @SerializedName("size") val size: Int? = null,
    @SerializedName("stargazers_count") val stargazersCount: Int? = null,
    @SerializedName("watchers_count") val watchersCount: Int? = null,
    @SerializedName("language") val language: String? = null,
    @SerializedName("forks_count") val forksCount: Int? = null,
    @SerializedName("open_issues_count") val openIssuesCount: Int? = null,
    @SerializedName("master_branch") val masterBranch: String? = null,
    @SerializedName("default_branch") val defaultBranch: String? = null,
    @SerializedName("score") val score: Double? = null
) : Parcelable

@Parcelize
data class Owner(
    @SerializedName("login") val login: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("node_id") val nodeId: String? = null,
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("gravatar_id") val gravatarId: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("received_events_url") val receivedEventsUrl: String? = null,
    @SerializedName("type") val type: String? = null
) : Parcelable