package com.example.retrofitapp.data.remote.api

import com.example.navapp.data.model.ArticalNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApi {

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "11a594b1e18a4e1b859144846fd7ba01"
    }

    @GET("everything")
    fun getEveryThingNews(
        @Query("q")
        query :String ,
        @Query("apiKey")
        apiKey :String = API_KEY
    ) : Call<ArticalNews>
}