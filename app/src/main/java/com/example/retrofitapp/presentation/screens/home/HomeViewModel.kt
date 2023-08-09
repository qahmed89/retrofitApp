package com.example.retrofitapp.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.navapp.data.model.ArticalNews
import com.example.navapp.data.model.Article
import com.example.retrofitapp.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel(){
    private val newApi = RetrofitClient().newApi

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()
    init {
        getArticle()
    }
    private fun getArticle() {
        newApi.getEveryThingNews(query = "bitcoin").enqueue(object  : Callback<ArticalNews> {
            override fun onResponse(call: Call<ArticalNews>, response: Response<ArticalNews>) {
                if (!response.isSuccessful) return
                _homeState.update {
                    it.copy(isLoading = false,listArticle = response.body()?.articles)
                }
            }

            override fun onFailure(call: Call<ArticalNews>, t: Throwable) {
                Log.i("Error" , t.localizedMessage)
            }

        })


    }
}
data class HomeState(
    val isLoading : Boolean = true,
    val listArticle : List<Article?>? = emptyList()

)