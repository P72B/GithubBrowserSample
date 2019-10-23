package de.p72b.umi.github.koin

import de.p72b.umi.github.BuildConfig
import de.p72b.umi.github.arch.RepositoryRepository
import de.p72b.umi.github.services.Configuration
import de.p72b.umi.github.services.WebService
import org.koin.dsl.module

val appModule = module {
    single { RepositoryRepository() }
    single {
        WebService(object : Configuration {
            override val apiGitHubSearchServiceUrl: String
                get() = BuildConfig.BACKEND_GITHUB_SEARCH
        })
    }
}