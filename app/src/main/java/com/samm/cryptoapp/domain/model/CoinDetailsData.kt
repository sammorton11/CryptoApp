package com.samm.cryptoapp.domain.model

import com.samm.cryptoapp.data.dto.coin_details.Links
import com.samm.cryptoapp.data.dto.coin_details.LinksExtended
import com.samm.cryptoapp.data.dto.coin_details.Tag
import com.samm.cryptoapp.data.dto.coin_details.Team

data class CoinDetailsData(
    val coinId: String,
    val name: String?,
    val description: String?,
    val symbol: String?,
    val rank: Int?,
    val isActive: Boolean?,
    val logo: String?,
    val links: Links?,
    val linksExtended: List<LinksExtended?>,
    val message: String?,
    val tags: List<Tag?>,
    val team: List<Team>?,
)
