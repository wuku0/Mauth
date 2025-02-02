package com.xinto.mauth.core.settings

import com.xinto.mauth.core.settings.model.SortSetting
import kotlinx.coroutines.flow.Flow

interface Settings {
    fun getSecureMode(): Flow<Boolean>
    fun getSortMode(): Flow<SortSetting>

    suspend fun setSecureMode(value: Boolean)
    suspend fun setSortMode(value: SortSetting)
}