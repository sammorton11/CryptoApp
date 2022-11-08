package com.samm.cryptoapp.domain.model

import com.samm.cryptoapp.data.remote.dto.Links
import com.samm.cryptoapp.data.remote.dto.LinksExtended
import com.samm.cryptoapp.data.remote.dto.Tag
import com.samm.cryptoapp.data.remote.dto.Team

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
