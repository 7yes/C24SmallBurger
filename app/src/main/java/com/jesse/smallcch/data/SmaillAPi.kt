package com.jesse.smallcch.data

import com.jesse.smallcch.data.model.SmallResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface SmaillAPi {

    @GET("characters")
    suspend fun getApiData(): Response<List<SmallResponseItem>>
}