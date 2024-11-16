package com.jesse.smallcch.data

import com.jesse.smallcch.data.model.SmallResponseItem
import javax.inject.Inject

class SmallRepo @Inject constructor(private val serv: SmallServ) {
    suspend fun getData(): List<SmallResponseItem> {
        return serv.getData()
    }
}