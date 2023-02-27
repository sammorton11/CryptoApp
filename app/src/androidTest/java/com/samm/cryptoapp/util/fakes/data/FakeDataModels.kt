package com.samm.cryptoapp.util.fakes.data

import com.samm.cryptoapp.data.dto.coin_details.*
import com.samm.cryptoapp.data.dto.price_details.BTC
import com.samm.cryptoapp.data.dto.price_details.Quotes
import com.samm.cryptoapp.data.dto.price_details.USD
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.coin_price_test
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeLinkType
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeLinksExtendedUrl
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fake_ath_date
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.market_cap_BTC_test
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.market_cap_USD_test
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.negative_percentage_change
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.positive_percentage_change
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.tag_id
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.tag_name
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.team_member_Id
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.team_member_name
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.team_member_position
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_coin_counter
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_contributors
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_explorer
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_facebook
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_ic_counter
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_medium
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_reddit
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_source_code
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_stars
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_subscribers
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_website
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.test_youtube

object FakeDataModels {

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
        ath_price = positive_percentage_change,
        market_cap = market_cap_USD_test,
        market_cap_change_24h = positive_percentage_change,
        percent_change_12h = positive_percentage_change,
        percent_change_15m = positive_percentage_change,
        percent_change_1h = positive_percentage_change,
        percent_change_1y = positive_percentage_change,
        percent_change_24h = negative_percentage_change,
        percent_change_30d = negative_percentage_change,
        percent_change_30m = negative_percentage_change,
        percent_change_6h = negative_percentage_change,
        percent_change_7d = negative_percentage_change,
        percent_from_price_ath = positive_percentage_change,
        price = coin_price_test,
        volume_24h = positive_percentage_change,
        volume_24h_change_24h = positive_percentage_change
    )



    private val fakeBTC = BTC(
        ath_date = fake_ath_date,
        ath_price = positive_percentage_change,
        market_cap = market_cap_BTC_test,
        market_cap_change_24h = positive_percentage_change,
        percent_change_12h = positive_percentage_change,
        percent_change_15m = positive_percentage_change,
        percent_change_1h = positive_percentage_change,
        percent_change_1y = positive_percentage_change,
        percent_change_24h = positive_percentage_change,
        percent_change_30d = positive_percentage_change,
        percent_change_30m = positive_percentage_change,
        percent_change_6h = positive_percentage_change,
        percent_change_7d = positive_percentage_change,
        percent_from_price_ath = positive_percentage_change,
        price = positive_percentage_change,
        volume_24h = positive_percentage_change,
        volume_24h_change_24h = positive_percentage_change
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