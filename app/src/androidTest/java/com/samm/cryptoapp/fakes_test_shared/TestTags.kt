package com.samm.cryptoapp.fakes_test_shared


// Might just make this a class with inner classes - though they are just strings
// Maybe create a module with all strings/tags and share it between the project
// and the test modules.
object TestTags {

    object CoinListScreenTags{
        const val CoinListScreenTag = "Coin List Screen Tag"
        const val SearchFieldTestTag = "Search Field Tag"
        const val SearchFieldLabelTestTag = "Search Field Label Tag"
        const val ErrorTestTag = "Error Tag"
        const val ProgressBarTestTag = "Progress Bar Tag"

        const val TitleTestTag = "Title Test Tag"
        const val RefreshButtonTestTag = "Refresh Button Test Tag"
        const val TopBarTestTag = "Top Bar Test Tag"
        const val SearchResults = "Search Results Label Tag"
    }

    object CoinListItemTags{
        const val CoinDetailsScreenTag = "Coin Details Screen"
        const val CoinCardTestTag = "Coin Card Tag"
        const val CoinCardLabelsTag = "Coin Card Labels Tag"
        const val CoinActivityTag = "Coin Activity Tag"
    }

    object CoinDetailsTags {
        const val BackButtonTestTag = "Back Button Test Tag"
        const val CoinPriceTitleTag = "Coin Price Title Tag"
        const val MaxSupplyTestTag = "Max Supply Tag"
        const val PriceCardTag = "Price Card Tag"
        const val DescriptionTag = "Description Card Tag"
        const val DescriptionTitleTag = "Description Title Tag"
    }

    object CoinPriceDetailsTags {

        const val PercentageChange15mLabelTag = "Percentage Change 15m label"
        const val PercentageChange15mTag = "Percentage Change 15m"

        const val PercentageChange30mLabelTag = "Percentage Change 30m label"
        const val PercentageChange30mTag = "Percentage Change 30m"

        const val PercentageChange1hrLabelTag = "Percentage Change 1hr label"
        const val PercentageChange1hrTag = "Percentage Change 1hr"

        const val PercentageChange6hrLabelTag = "Percentage Change 6hr label"
        const val PercentageChange6hrTag = "Percentage Change 6hr"

        const val PercentageChange12hrLabelTag = "Percentage Change 12hr label"
        const val PercentageChange12hrTag = "Percentage Change 12hr"

        const val PercentageChange24hrLabelTag = "Percentage Change 24hr label"
        const val PercentageChange24hrTag = "Percentage Change 24hr"

        const val PercentageChange7dLabelTag = "Percentage Change 7d label"
        const val PercentageChange7dTag = "Percentage Change 7d"

        const val PercentageChange30dLabelTag = "Percentage Change 30d label"
        const val PercentageChange30dTag = "Percentage Change 30d"

        const val PercentageChange1yrLabelTag = "Percentage Change 1yr label"
        const val PercentageChange1yrTag = "Percentage Change 1yr"

    }
}