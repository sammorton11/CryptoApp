package com.samm.cryptoapp.fakes

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.coin_details.toCoinDetail
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetCoinDetailsUseCase {

    // Identical to the code for a successful response from the use case class
    fun getCoinDetailsFakeResponse(id: String, repository: CryptoRepository): Flow<Resource<CoinDetailsData>> = flow {
        val coin = repository.getCoinDetails(id).toCoinDetail()
        emit(Resource.Success(coin))
    }
}