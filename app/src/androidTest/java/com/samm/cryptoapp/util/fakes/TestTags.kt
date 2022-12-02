package com.samm.cryptoapp.util.fakes

import com.samm.cryptoapp.R


// Might just make this a class with inner classes - though they are just strings
// Maybe create a module with all strings/tags and share it between the project
// and the test modules.
class TestTags {

    object CoinListScreenTags{
        const val CoinListScreenTag = R.string.coin_list_screen_tag
        const val ErrorTestTag = "Error Tag"
        const val ProgressBarTestTag = "Progress Bar Tag"

        const val TitleTestTag = R.string.title_test_tag
        const val RefreshButtonTestTag = R.string.refresh_button_test_tag
        const val TopBarTestTag = R.string.top_bar_test_tag
    }

    object CoinListItemTags{

        const val CoinCardTestTag = R.string.coin_card_tag
        const val CoinCardLabelsTag = R.string.coin_card_labels_tag
        const val CoinStatusTag = R.string.coin_status_tag
    }

    object CoinDetailsTags {
        const val exploreCardTitle = R.string.explore_card_title_text
        const val CoinDetailsScreenTag = R.string.coin_details_screen_tag
        const val CompanyLogoTag = R.string.company_logo_tag
        const val BackButtonTestTag = R.string.back_button_tag

        const val CoinPriceTitleTag = R.string.coin_price_title_tag
        const val MaxSupplyTestTag = R.string.max_supply_tag
        const val PriceCardTag = R.string.price_card_tag
        const val PriceCardDetailsTag = R.string.price_card_details_tag

        const val DescriptionTag = R.string.description_card_tag
        const val DescriptionTitleTag = R.string.description_title_tag
        const val DescriptionTitleExpandedTag = R.string.description_title_expanded_tag
        const val DescriptionTextTag = R.string.description_text_test_tag

        const val TeamTitleTestTag = R.string.team_card_title_tag
        const val TeamDetailsTestTag = R.string.team_details_tag
        const val TeamCardTestTag = R.string.team_card_tag

        const val TagsDetailsTag = R.string.tags_details_tag
        const val TagsTitleTag = R.string.tags_title_tag
        const val TagsCardTag = R.string.tags_card_tag

        const val SocialMediaTitleTag = R.string.social_media_title_tag
        const val SocialMediaDetailsTag = R.string.social_media_details_tag
        const val SocialMedialCardTag = R.string.social_media_card_tag

        const val ExploreTitleTag = R.string.explore_card_title_tag
        const val ExploreDetailsTag = R.string.explore_details_tag
        const val ExploreCardTag = R.string.explore_card_tag

        const val WebsiteButtonTag = R.string.website_button_tag
        const val LinkTestTag = R.string.link_test_tag

    }

    object CoinPriceDetailsTags {

        const val PercentageChange15mLabelTag = R.string.percentage_fifteen_minutes_label_tag
        const val PercentageChange15mTag = R.string.percentage_change_fifteen_minutes_tag

        const val PercentageChange30mLabelTag = R.string.percentage_thirty_minutes_label_tag
        const val PercentageChange30mTag = R.string.percentage_change_thirty_minutes_tag

        const val PercentageChange1hrLabelTag = R.string.percentage_one_hour_label_tag
        const val PercentageChange1hrTag = R.string.percentage_change_one_hour_tag

        const val PercentageChange6hrLabelTag = R.string.percentage_six_hours_label_tag
        const val PercentageChange6hrTag = R.string.percentage_change_six_hours_tag

        const val PercentageChange12hrLabelTag = R.string.percentage_twelve_hours_label_tag
        const val PercentageChange12hrTag = R.string.percentage_change_twelve_hours_tag

        const val PercentageChange24hrLabelTag = R.string.percentage_twenty_four_hours_label_tag
        const val PercentageChange24hrTag = R.string.percentage_change_twenty_four_tag

        const val PercentageChange7dLabelTag = R.string.percentage_seven_days_label_tag
        const val PercentageChange7dTag = R.string.percentage_change_seven_days_tag

        const val PercentageChange30dLabelTag = R.string.percentage_thirty_days_label_tag
        const val PercentageChange30dTag = R.string.percentage_change_thirty_days_tag

        const val PercentageChange1yrLabelTag = R.string.percentage_one_year_label_tag
        const val PercentageChange1yrTag = R.string.percentage_change_one_year_tag

    }
}