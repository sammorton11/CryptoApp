package com.samm.cryptoapp.domain.model

import com.samm.cryptoapp.data.remote.dto.*

data class CoinDetailsData(
    val coinId: String,
    val name: String?,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val logo: String?,
    val message: String?,
    val tags: List<String?>,
    val team: List<Team>,
    val whitePaper: Whitepaper
)
