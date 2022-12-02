package com.samm.cryptoapp.util.fakes.use_case

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.price_details.toCoinPriceDetail
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.util.fakes.FakeCryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetCoinPriceDetailsUseCase(
    private val isSuccessful: Boolean = true,
    private val repository: FakeCryptoRepository = FakeCryptoRepository()
) : GetSingleCoinPriceUseCase {

    override fun invoke(id: String): Flow<Resource<CoinPriceDetailsData>> {
        return when {
            isSuccessful -> flow {
                val coin = repository.getPriceCoinDetails(id).toCoinPriceDetail()
                emit(Resource.Success(coin))
            }
            else -> flow { emit(Resource.Error("Error"))  }
        }
    }
}