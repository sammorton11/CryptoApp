package com.samm.cryptoapp.fakes


import com.samm.cryptoapp.R
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.data.remote.dto.price_details.Quotes
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinId01
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinId02
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinId03
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinName01
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinName02
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinName03
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinType
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeDetailDescription
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeDetailName
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeDevelopmentStatus
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeFirstDataAtData
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeHashAlg
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeLastDataAtData
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeLastUpdated
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeMessage
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeOrgStructure
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeProofType
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeStartedAtDate
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeSymbol
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.firstCoinRank
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.secondCoinRank
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.thirdCoinRank
import com.samm.cryptoapp.fakes.FakeTeam.fakeLink
import com.samm.cryptoapp.fakes.FakeTeam.fakeTag
import com.samm.cryptoapp.fakes.FakeTeam.fakeTeamMember

object FakeDataSource {

    object FakeData {
        val fakeDetailName = buildString { R.string.fake_coin_details_name }
        val fakeDetailDescription = buildString { R.string.fake_coin_details_name }

        val fakeCoinName01 = buildString { append(R.string.fake_coin_name_01) }
        val fakeCoinName02 = buildString { append(R.string.fake_coin_name_02) }
        val fakeCoinName03 = buildString { append(R.string.fake_coin_name_03) }

        val fakeCoinId01 = buildString { append(R.string.fake_coin_id_01) }
        val fakeCoinId02 = buildString { append(R.string.fake_coin_id_02) }
        val fakeCoinId03 = buildString { append(R.string.fake_coin_id_03) }

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
        const val firstCoinRank = 1
        const val secondCoinRank = 2
        const val thirdCoinRank = 3
    }


    val fakeCoins = listOf(
        CoinDto(
            id = fakeCoinId01,
            is_active = true,
            is_new = false,
            name = fakeCoinName01,
            rank = firstCoinRank,
            symbol = fakeSymbol,
            type = fakeCoinType
        ),
        CoinDto(
            id = fakeCoinId02,
            is_active = false,
            is_new = true,
            name = fakeCoinName02,
            rank = secondCoinRank,
            symbol = fakeSymbol,
            type = fakeCoinType
        ),
        CoinDto(
            id = fakeCoinId03,
            is_active = true,
            is_new = false,
            name = fakeCoinName03,
            rank = thirdCoinRank,
            symbol = fakeSymbol,
            type = fakeCoinType
        )
    )

    // For coin 1
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
        quotes = Quotes(FakeTeam.fakeBTC, FakeTeam.fakeUSD),
        rank = 1,
        symbol = fakeSymbol,
        total_supply = 1000L
    )
}
