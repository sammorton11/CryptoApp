package com.samm.cryptoapp.util.fakes.data

import com.samm.cryptoapp.data.dto.CoinDto
import com.samm.cryptoapp.data.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.circulating_supply
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeDetailDescription
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeDevelopmentStatus
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeFirstDataAtData
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeHashAlg
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeLastUpdated
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeLogoUrl
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeMessage
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeOrgStructure
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeProofType
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeStartedAtDate
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.max_supply
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.positive_percentage_change
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.total_supply
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeCoinId01
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeCoinName01
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeCoinType
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeSymbol
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.firstCoinRank
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.is_active
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.is_new
import com.samm.cryptoapp.util.fakes.data.FakeDataModels.FakeLinksExtendedSuccess.fakeLinksExtended
import com.samm.cryptoapp.util.fakes.data.FakeDataModels.fakeLink
import com.samm.cryptoapp.util.fakes.data.FakeDataModels.fakeQuotes
import com.samm.cryptoapp.util.fakes.data.FakeDataModels.fakeTag
import com.samm.cryptoapp.util.fakes.data.FakeDataModels.fakeTeamMember

object FakeDto {

    val fakeCoins = listOf(
        CoinDto(
            id = fakeCoinId01,
            is_active = is_active,
            is_new = is_new,
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
        lastDataAt = fakeLastUpdated,
        links = fakeLink,
        linksExtended = fakeLinksExtended,
        logo = fakeLogoUrl,
        message = fakeMessage,
        name = fakeDetailNameExpanded,
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

    val fakeCoinPriceDetails = CoinPriceDetailsDtoItem(
        beta_value = positive_percentage_change,
        circulating_supply = circulating_supply,
        first_data_at = fakeFirstDataAtData,
        id = fakeCoinId01,
        last_updated = fakeLastUpdated,
        max_supply = max_supply,
        name = fakeCoinName01,
        quotes = fakeQuotes,
        rank = firstCoinRank,
        symbol = fakeSymbol,
        total_supply = total_supply
    )
}