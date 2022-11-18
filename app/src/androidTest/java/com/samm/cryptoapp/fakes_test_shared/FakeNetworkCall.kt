package com.samm.cryptoapp.fakes_test_shared

import com.samm.cryptoapp.R
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.coin_details.Links
import com.samm.cryptoapp.data.remote.dto.coin_details.Tag
import com.samm.cryptoapp.data.remote.dto.coin_details.Team
import com.samm.cryptoapp.data.remote.dto.price_details.BTC
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.data.remote.dto.price_details.Quotes
import com.samm.cryptoapp.data.remote.dto.price_details.USD
import com.samm.cryptoapp.fakes_test_shared.FakeBTC.fakeBTC
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeCoinId01
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeCoinName01
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeCoinType
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeDetailDescription
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeDetailName
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeDevelopmentStatus
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeFirstDataAtData
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeHashAlg
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeLastDataAtData
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeLastUpdated
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeMessage
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeOrgStructure
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeProofType
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeStartedAtDate
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeSymbol
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.firstCoinRank
import com.samm.cryptoapp.fakes_test_shared.FakeLinks.fakeLink
import com.samm.cryptoapp.fakes_test_shared.FakeTag.fakeTag
import com.samm.cryptoapp.fakes_test_shared.FakeTeam.fakeTeamMember
import com.samm.cryptoapp.fakes_test_shared.FakeUSD.fakeUSD

object FakeDataSource {

    object FakeData {

        val fakeCoinName01 = buildString { append(R.string.fake_coin_name_01) }
        val fakeCoinId01 = buildString { append(R.string.fake_coin_id_01) }
        val fakeSymbol = buildString { append(R.string.test_symbol)}
        val fakeCoinType = buildString { append(R.string.fake_coin_type) }
        val fakeDevelopmentStatus = buildString { append(R.string.fake_developmentStatus01) }

        val fakeFirstDataAtData = buildString { append(R.string.fake_firstDataAt_date) }
        val fakeHashAlg = buildString { R.string.fake_hashAlgorithm }
        val fakeLastDataAtData = buildString { R.string.fake_lastDataAt_date }

        val fakeMessage = buildString { R.string.fake_message }
        val fakeOrgStructure = buildString { R.string.fake_orgStructure }
        val fakeProofType = buildString { R.string.fake_proofType }
        
        val fakeStartedAtDate = buildString { R.string.fake_startedAt_date }
        val fakeLastUpdated = buildString { R.string.fake_lastUpdatedAt_date }

        val fakeDetailName = buildString { R.string.fake_coin_details_name }
        val fakeDetailDescription = buildString { R.string.fake_coin_details_name }

        const val firstCoinRank = 1
    }

    object FakeDto {

        val fakeCoins = listOf(
            CoinDto(
                id = fakeCoinId01,
                is_active = true,
                is_new = false,
                name = fakeCoinName01,
                rank = firstCoinRank,
                symbol = fakeSymbol,
                type = fakeCoinType
            )
        )

        val fakeCoinDetails = CoinDetailsDto(
            description = fakeDetailDescription,
            developmentStatus = fakeDevelopmentStatus,
            firstDataAt = fakeFirstDataAtData,
            hardwareWallet = true,
            hashAlgorithm = fakeHashAlg,
            id = fakeCoinId01,
            isActive = true,
            isNew = true,
            lastDataAt = fakeLastDataAtData,
            links = fakeLink,
            linksExtended = listOf(),
            logo = "fake_logo01",
            message = fakeMessage,
            name = fakeDetailName,
            openSource = true,
            orgStructure = fakeOrgStructure,
            proofType = fakeProofType,
            rank = 1,
            startedAt = fakeStartedAtDate,
            symbol = fakeSymbol,
            tags = listOf(fakeTag),
            team = listOf(fakeTeamMember),
            type = fakeCoinType
        )

        // For coin 1
        val fakeCoinPriceDetails = CoinPriceDetailsDtoItem(
            beta_value = 0.5,
            circulating_supply = 1000L,
            first_data_at = fakeFirstDataAtData,
            id = fakeCoinId01,
            last_updated = fakeLastUpdated,
            max_supply = 10000L,
            name = fakeCoinName01,
            quotes = Quotes(fakeBTC, fakeUSD),
            rank = 1,
            symbol = fakeSymbol,
            total_supply = 1000L
        )
    }
}


object FakeTeam {
    val fakeTeamMember = Team(
        id = "john_doe_01",
        name = "John Doe",
        position = "Tester"
    )
}

object FakeTag {
    val fakeTag = Tag(
        coin_counter = 1,
        ico_counter = 2,
        id = "fake_tag_01",
        name = "Fake Tag 01"
    )
}
object FakeLinks {
    val fakeLink = Links(
        explorer = listOf(""),
        facebook = listOf(""),
        medium = listOf(""),
        reddit = listOf(""),
        source_code = listOf(""),
        website = listOf(""),
        youtube = listOf("")
    )
}

object FakeUSD {
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
}

object FakeBTC {
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
