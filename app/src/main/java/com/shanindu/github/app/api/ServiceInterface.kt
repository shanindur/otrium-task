package com.shanindu.github.app.api

import com.shanindu.github.app.models.Repo
import com.shanindu.github.app.models.User
import com.shanindu.github.app.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Shanindu on 03/03/2021.
 */
interface ServiceInterface {

    @GET("users/shanindur")
    fun getUserData(): Observable<User>

    @GET("users/shanindur/repos")
    fun getPinnedRepos(): Observable<List<Repo>>

    companion object Factory {
        fun create(): ServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ServiceInterface::class.java)
        }
    }
}