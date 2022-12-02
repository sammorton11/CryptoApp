package com.samm.cryptoapp.util.fakes

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.*
import com.samm.cryptoapp.data.remote.dto.price_details.BTC
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.data.remote.dto.price_details.Quotes
import com.samm.cryptoapp.data.remote.dto.price_details.USD
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.circulating_supply
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.coin_price_test
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailDescription
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDevelopmentStatus
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeFirstDataAtData
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeHashAlg
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLastUpdated
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLinkType
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLinksExtendedUrl
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLogoUrl
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeMessage
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeOrgStructure
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeProofType
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeStartedAtDate
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fake_ath_date
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.market_cap_BTC_test
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.market_cap_USD_test
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.max_supply
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.negative_double
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.positive_double
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.tag_id
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.tag_name
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.team_member_Id
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.team_member_name
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.team_member_position
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_coin_counter
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_contributors
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_explorer
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_facebook
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_ic_counter
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_medium
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_reddit
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_source_code
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_stars
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_subscribers
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_website
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_youtube
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.total_supply
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinName01
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinType
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.fakeSymbol
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.firstCoinRank
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.is_active
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.is_new
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.FakeLinksExtendedSuccess.fakeLinksExtended
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.fakeLink
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.fakeQuotes
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.fakeTag
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.fakeTeamMember

class FakeDataSource {

    object FakeData {


        object CoinListScreenFakes {
            const val is_active = true
            const val is_new = true
            const val firstCoinRank = 1
            const val is_active_text = "active"
            const val test_title = "Top 100 Crypto Coins"
            const val expectedCardData = "1.  Test Coin (TTC)"
            const val active_text = "active"
            const val inactive_text = "in_active"
            const val fakeCoinName01 = "Test Coin"
            const val fakeCoinId01 = "id"
            const val fakeSymbol = "TTC"
            const val fakeCoinType = "Test Type"
        }

        object CoinDetailsScreenFakes {

            const val explore_card_title = "Explore"
            const val social_media_card_title = "Social Media"
            const val description_card_title = "Description"
            const val price_card_title = "Price"
            const val tags_card_title = "Tags"
            const val team_card_title = "Team"

            const val fakeLogoUrl = "https://static.coinpaprika.com/coin/bnb-binance-coin/logo.png"
            const val backButton = "Back"
            const val fakeDevelopmentStatus = "Test Status"
            const val fakeHashAlg = "hash alg"
            const val fakeMessage = "Test Message"
            const val fakeOrgStructure = "Test Org Structure"
            const val fakeProofType = "Test Proof Type"
            const val fakeStartedAtDate = "Test Started At"
            const val fakeFirstDataAtData = "Test First Data At"
            const val fakeLastUpdated = "Test Last Data At"
            const val fakeDetailNameCollapsed = "Test Coin Name"
            const val fakeDetailNameExpanded = "Test Coin"
            const val fakeDetailDescription = "Test Description"
            const val fakeTeamMemberName = "Team Member"
            const val fakeLinkType = "google"
            const val fakeLinksExtendedUrl = "https://www.google.com/"

            const val test_explorer = "http://blockchain.com/explorer"
            const val test_facebook = "https://www.facebook.com/bitcoins/"
            const val test_medium = "https://www.reddit.com/r/bitcoin"
            const val test_reddit = "https://www.reddit.com/r/bitcoin"
            const val test_source_code = "https://github.com/bitcoin/bitcoin"
            const val test_website = "https://bitcoin.org/"
            const val test_youtube = "https://www.youtube.com/watch?v=Um63OQz3bjo"

            const val fake_ath_date = "2017-12-17T12:19:00Z"

            const val positive_double = 0.5
            const val negative_double = -0.5

            const val market_cap_BTC_test = 1000
            const val market_cap_USD_test = 1000L
            const val max_supply = 2000L
            const val total_supply = 1000L
            const val circulating_supply = 3000L
            const val coin_price_test = 10000.00

            const val team_member_Id = "john_doe_01"
            const val team_member_name = "John Doe"
            const val team_member_position = "Tester"
            const val tag_id = "tag id"
            const val tag_name = "tag name test"

            const val test_contributors = 5
            const val test_stars = 20
            const val test_subscribers = 100

            const val test_coin_counter = 15
            const val test_ic_counter = 20
        }

        val fakeLink = Links(
            explorer = listOf(test_explorer),
            facebook = listOf(test_facebook),
            medium = listOf(test_medium),
            reddit = listOf(test_reddit),
            source_code = listOf(test_source_code),
            website = listOf(test_website),
            youtube = listOf(test_youtube)
        )


        private val fakeUSD = USD(
            ath_date = fake_ath_date,
            ath_price = positive_double,
            market_cap = market_cap_USD_test,
            market_cap_change_24h = positive_double,
            percent_change_12h = positive_double,
            percent_change_15m = positive_double,
            percent_change_1h = positive_double,
            percent_change_1y = positive_double,
            percent_change_24h = negative_double,
            percent_change_30d = negative_double,
            percent_change_30m = negative_double,
            percent_change_6h = negative_double,
            percent_change_7d = negative_double,
            percent_from_price_ath = positive_double,
            price = coin_price_test,
            volume_24h = positive_double,
            volume_24h_change_24h = positive_double
        )



        private val fakeBTC = BTC(
            ath_date = fake_ath_date,
            ath_price = positive_double,
            market_cap = market_cap_BTC_test,
            market_cap_change_24h = positive_double,
            percent_change_12h = positive_double,
            percent_change_15m = positive_double,
            percent_change_1h = positive_double,
            percent_change_1y = positive_double,
            percent_change_24h = positive_double,
            percent_change_30d = positive_double,
            percent_change_30m = positive_double,
            percent_change_6h = positive_double,
            percent_change_7d = positive_double,
            percent_from_price_ath = positive_double,
            price = positive_double,
            volume_24h = positive_double,
            volume_24h_change_24h = positive_double
        )


        object FakeLinksExtendedSuccess {
            private val fake = LinksExtended(
                stats = fakeStats,
                type = fakeLinkType,
                url = fakeLinksExtendedUrl
            )
            val fakeLinksExtended = listOf(fake)
        }

        val fakeStats = Stats(
            contributors = test_contributors,
            stars = test_stars,
            subscribers = test_subscribers
        )

        val fakeQuotes = Quotes(fakeBTC, fakeUSD)

        val fakeTeamMember = Team(
            id = team_member_Id,
            name = team_member_name,
            position = team_member_position
        )

        val fakeTag = Tag(
            coin_counter = test_coin_counter,
            ico_counter = test_ic_counter,
            id = tag_id,
            name = tag_name
        )

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
            beta_value = positive_double,
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
}





