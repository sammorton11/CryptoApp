package com.samm.cryptoapp.domain.use_case.get_coin_details_data

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinDetailsData
import kotlinx.coroutines.flow.Flow

interface GetCoinDetailsUseCase {

    operator fun invoke(id: String): Flow<Resource<CoinDetailsData>>
}