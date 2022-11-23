package com.samm.cryptoapp.util.fakes_test_shared

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.coin_details.toCoinDetail
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinUseCase
import com.samm.cryptoapp.fakes.FakeCryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetCoinDetailsUseCase(
    private val isSuccessful: Boolean = true,
    private val repository: FakeCryptoRepository = FakeCryptoRepository()
) : GetSingleCoinUseCase(repository) {

    override fun invoke(id: String): Flow<Resource<CoinDetailsData>> {
        return when {
            isSuccessful -> flow {
                val coin = repository.getCoinDetails(id).toCoinDetail()
                emit(Resource.Success(coin))
            }
            else -> flow { emit(Resource.Error("Error"))  }
        }
    }
}