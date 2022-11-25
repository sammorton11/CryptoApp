package com.samm.cryptoapp.util.fakes_test_shared

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetListOfCoinsUseCase(
    private val isSuccessful: Boolean = true,
    private val repository: FakeCryptoRepository = FakeCryptoRepository()
): GetListOfCoinsUseCase {

    override fun invoke(): Flow<Resource<List<CoinData>>> {
        return when {
            isSuccessful -> flow {
                val coins = repository.getCoinData().map { it.toCoin() }
                emit(Resource.Success(coins))
            }
            else -> {
                flow { emit(Resource.Error("Error")) }
            }
        }
    }
}