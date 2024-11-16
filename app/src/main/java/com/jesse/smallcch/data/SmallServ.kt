package com.jesse.smallcch.data

import com.jesse.smallcch.data.model.SmallResponseItem
import javax.inject.Inject

class SmallServ @Inject constructor(private val api: SmaillAPi) {
    suspend fun getData(): List<SmallResponseItem> {
        val response = api.getApiData()
        val body = response.body()
        return body ?: emptyList()
    }
}
