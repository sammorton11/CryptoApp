package com.samm.cryptoapp.fakes

import com.samm.cryptoapp.data.remote.dto.coin_details.Links
import com.samm.cryptoapp.data.remote.dto.coin_details.Tag
import com.samm.cryptoapp.data.remote.dto.coin_details.Team
import com.samm.cryptoapp.data.remote.dto.price_details.BTC
import com.samm.cryptoapp.data.remote.dto.price_details.USD

object FakeTeam {
    
    val fakeTeamMember = Team(
        id = "john_doe_01",
        name = "John Doe",
        position = "Tester"
    )

    val fakeTag = Tag(
        coin_counter = 1,
        ico_counter = 2,
        id = "fake_tag_01",
        name = "Fake Tag 01"
    )

    val fakeLink = Links(
        explorer = listOf(""),
        facebook = listOf(""),
        medium = listOf(""),
        reddit = listOf(""),
        source_code = listOf(""),
        website = listOf(""),
        youtube = listOf("")
    )

    val fakeUSD = USD(
        ath_date = "",
        ath_price = 0.5,
        market_cap = 10L,
        market_cap_change_24h = 0.5,
        percent_change_12h = 0.5,
        percent_change_15m = 0.5,
        percent_change_1h = 0.5,
        percent_change_1y = 0.5,
        percent_change_24h = 0.5,
        percent_change_30d = 0.5,
        percent_change_30m = 0.5,
        percent_change_6h = 0.5,
        percent_change_7d = 0.5,
        percent_from_price_ath = 0.5,
        price = 0.5,
        volume_24h = 0.5,
        volume_24h_change_24h = 0.5
    )
    val fakeBTC = BTC(
        ath_date = "",
        ath_price = 0.5,
        market_cap = 10,
        market_cap_change_24h = 0.5,
        percent_change_12h = 5,
        percent_change_15m = 5,
        percent_change_1h = 5,
        percent_change_1y = 5,
        percent_change_24h = 5,
        percent_change_30d = 5,
        percent_change_30m = 5,
        percent_change_6h = 5,
        percent_change_7d = 5,
        percent_from_price_ath = 0.5,
        price = 5,
        volume_24h = 0.5,
        volume_24h_change_24h = 0.5
    )
    
}