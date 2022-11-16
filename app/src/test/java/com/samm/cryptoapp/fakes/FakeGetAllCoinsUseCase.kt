package com.samm.cryptoapp.fakes

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetAllCoinsUseCase {
    // Identical to the code for a successful response from the use case class
    fun getCoinsFakeResponse(repository: CryptoRepository): Flow<Resource<List<CoinData>>> = flow {
        val list: List<CoinData> = repository.getCoinData().map { it.toCoin() }
        emit(Resource.Success(list))
    }
}