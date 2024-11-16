package com.jesse.smallcch.Domain

import com.jesse.smallcch.data.SmallRepo
import com.jesse.smallcch.data.model.SmallResponseItem
import javax.inject.Inject

class GetDataUC @Inject constructor(private val repo: SmallRepo) {
    suspend operator fun invoke(): List<SmallResponseItem> {
        return repo.getData()
    }
}