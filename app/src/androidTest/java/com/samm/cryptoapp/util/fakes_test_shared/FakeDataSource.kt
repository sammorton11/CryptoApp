package com.samm.cryptoapp.util.fakes_test_shared

import com.samm.cryptoapp.R
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.*
import com.samm.cryptoapp.data.remote.dto.price_details.BTC
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.data.remote.dto.price_details.Quotes
import com.samm.cryptoapp.data.remote.dto.price_details.USD
import com.samm.cryptoapp.util.TestContext.appContext
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailDescription
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDevelopmentStatus
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeFirstDataAtData
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeHashAlg
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLastDataAtData
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLastUpdated
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeMessage
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeOrgStructure
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeProofType
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeStartedAtDate
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeTagText
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_explorer
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_facebook
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_link_extended_url
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_medium
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_reddit
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_source_code
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_website
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_youtube
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinName01
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinType
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeSymbol
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.firstCoinRank
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.is_active
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.is_new
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeBTCSuccess.fakeBTC
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeLinksExtendedSuccess.fakeLinksExtended
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeLinksSuccess.fakeLink
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeQuotesSuccess.fakeQuotes
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeStatsSuccess.fakeStats
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeTagSuccess.fakeTag
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeTeamSuccess.fakeTeamMember
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.FakeUSDSuccess.fakeUSD

class FakeDataSource {

    object FakeData {

        object CoinListScreenFakes {
            const val is_active = true
            const val is_new = true
            const val firstCoinRank = 1
            val test_title = appContext.getString(R.string.test_title_coin_list_screen)
            val expectedCardData = appContext.getString(R.string.expected_card_data)
            val is_active_text = appContext.getString(R.string.is_active_text_test)
            val inactive_text = appContext.getString(R.string.inactive_test_text)
            val fakeCoinName01 = appContext.getString(R.string.fake_coin_name_01)
            val fakeCoinId01 = appContext.getString(R.string.fake_coin_id_01)
            val fakeSymbol = appContext.getString(R.string.coin_test_symbol)
            val fakeCoinType = appContext.getString(R.string.fake_coin_type)
        }

        object CoinDetailsScreenFakes {

            val backButton = appContext.getString(R.string.backButtonLabel)
            val fakeDevelopmentStatus = appContext.getString(R.string.fake_developmentStatus01)
            val fakeFirstDataAtData = appContext.getString(R.string.fake_firstDataAt_date)
            val fakeHashAlg = appContext.getString(R.string.fake_hashAlgorithm)
            val fakeLastDataAtData = appContext.getString(R.string.fake_lastDataAt_date)
            val fakeMessage = appContext.getString(R.string.fake_message)
            val fakeOrgStructure = appContext.getString(R.string.fake_orgStructure)
            val fakeProofType = appContext.getString(R.string.fake_proofType)
            val fakeStartedAtDate = appContext.getString(R.string.fake_startedAt_date)
            val fakeLastUpdated = appContext.getString(R.string.fake_lastUpdatedAt_date)
            val fakeDetailNameCollapsed = appContext.getString(R.string.description_card_title)
            val fakeDetailNameExpanded = appContext.getString(R.string.fake_coin_details_name)
            val fakeDetailDescription = appContext.getString(R.string.fake_coin_details_description)
            val fakeTeamMemberName = appContext.getString(R.string.fake_team_member)
            val fakeTagText = appContext.getString(R.string.tags_text)

            const val test_explorer = "http://blockchain.com/explorer"
            const val test_facebook = "https://www.facebook.com/bitcoins/"
            const val test_medium = "https://www.reddit.com/r/bitcoin"
            const val test_reddit = "https://www.reddit.com/r/bitcoin"
            const val test_source_code = "https://github.com/bitcoin/bitcoin"
            const val test_website = "https://bitcoin.org/"
            const val test_youtube = "https://www.youtube.com/watch?v=Um63OQz3bjo"

            const val test_link_extended_url = "https://www.google.com/"
        }

            object FakeLinksSuccess {

                val fakeLink = Links(
                    explorer = listOf(test_explorer),
                    facebook = listOf(test_facebook),
                    medium = listOf(test_medium),
                    reddit = listOf(test_reddit),
                    source_code = listOf(test_source_code),
                    website = listOf(test_website),
                    youtube = listOf(test_youtube)
                )
            }

            object FakeUSDSuccess {
                val fakeUSD = USD(
                    ath_date = "2017-12-17T12:19:00Z",
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

            object FakeBTCSuccess {
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

            object FakeLinksExtendedSuccess {
                private val fake = LinksExtended(
                    stats = fakeStats,
                    type = "google",
                    url = test_link_extended_url
                )
                val fakeLinksExtended = listOf(fake)
            }

            object FakeStatsSuccess{
                val fakeStats = Stats(
                    contributors = 10,
                    stars = 5,
                    subscribers = 100
                )
            }

            object FakeQuotesSuccess{
                val fakeQuotes = Quotes(fakeBTC, fakeUSD)
            }

            object FakeTeamSuccess {
                val fakeTeamMember = Team(
                    id = "john_doe_01",
                    name = "John Doe",
                    position = "Tester"
                )
            }

            object FakeTagSuccess {
                val fakeTag = Tag(
                    coin_counter = 1,
                    ico_counter = 2,
                    id = "fake_tag_01",
                    name = fakeTagText
                )
            }
    }

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
            lastDataAt = fakeLastDataAtData,
            links = fakeLink,
            linksExtended = fakeLinksExtended,
            logo = "https://static.coinpaprika.com/coin/bnb-binance-coin/logo.png",
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
            beta_value = 0.5,
            circulating_supply = 1000L,
            first_data_at = fakeFirstDataAtData,
            id = fakeCoinId01,
            last_updated = fakeLastUpdated,
            max_supply = 10000L,
            name = fakeCoinName01,
            quotes = fakeQuotes,
            rank = 1,
            symbol = fakeSymbol,
            total_supply = 1000L
        )
    }
}





