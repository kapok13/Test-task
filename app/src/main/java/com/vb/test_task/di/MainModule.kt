package com.vb.test_task.di

import com.vb.test_task.data.network.datasource.RedditAPI
import com.vb.test_task.data.network.repository.RedditRepoImpl
import com.vb.test_task.domain.repository.RedditRepo
import com.vb.test_task.ui.main.MainActivityVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val mainModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://www.reddit.com/")
            .build()
            .create(RedditAPI::class.java)
    }

    single<RedditRepo> {
        RedditRepoImpl(get())
    }

    viewModel {
        MainActivityVM(get())
    }
}