package com.samm.cryptoapp.domain.use_case.get_list_of_coins

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinData
import kotlinx.coroutines.flow.Flow

interface GetListOfCoinsUseCase {

     operator fun invoke(): Flow<Resource<List<CoinData>>>
}