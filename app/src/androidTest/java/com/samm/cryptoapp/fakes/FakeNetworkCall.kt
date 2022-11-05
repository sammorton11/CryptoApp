package com.samm.cryptoapp.fakes

import com.samm.cryptoapp.data.remote.dto.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.data.remote.dto.price_details.Quotes
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.data.remote.dto.toCoinDetail
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.fakes.FakeTeam.fakeLink
import com.samm.cryptoapp.fakes.FakeTeam.fakeTag
import com.samm.cryptoapp.fakes.FakeTeam.fakeTeamMember

object FakeNetworkCall {

    val fakeCoins = listOf(
        CoinDto(
            id = "fake_coin_01",
            is_active = true,
            is_new = false,
            name = "FakeCoin01",
            rank = 1,
            symbol = "test_symbol_01",
            type = "coin"
        ),
        CoinDto(
            id = "fake_coin_02",
            is_active = false,
            is_new = true,
            name = "FakeCoin02",
            rank = 2,
            symbol = "test_symbol_02",
            type = "coin"
        ),
        CoinDto(
            id = "fake_coin_03",
            is_active = true,
            is_new = false,
            name = "FakeCoin03",
            rank = 3,
            symbol = "test_symbol_02",
            type = "anti-coin"
        )
    )
    
    val fakeCoinDetails = CoinDetailsDto(
            description = "",
            "",
            "",
            true,
            "",
            "",
            true,
            true,
            "",
            fakeLink,
            listOf(),
            "",
            "",
            "",
            true,
            "",
            "",
            1,
            "",
            "",
            listOf(fakeTag),
            listOf(fakeTeamMember),
            ""
        )
    
    
    val fakeCoinPriceDetails = CoinPriceDetailsDtoItem(
        beta_value = 0.5,
        circulating_supply = 10L,
        first_data_at = "",
        id = "",
        last_updated = "",
        max_supply = 10L,
        name = "",
        quotes = Quotes(FakeTeam.fakeBTC, FakeTeam.fakeUSD),
        rank = 1,
        symbol = "",
        total_supply = 10L
    )
}