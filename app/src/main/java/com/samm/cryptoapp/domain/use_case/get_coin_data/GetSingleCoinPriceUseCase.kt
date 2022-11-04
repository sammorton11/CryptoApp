package com.samm.cryptoapp.domain.use_case.get_coin_data

import com.samm.cryptoapp.data.remote.dto.toCoinDetail
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.price_details.toCoinPriceDetail
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData

class GetSingleCoinPriceUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    operator fun invoke(id: String): Flow<Resource<CoinPriceDetailsData>> = flow {

        try {
            emit(Resource.Loading())
            val coin = repository.getPriceCoinDetails(id).toCoinPriceDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))

        } catch (e: IOException){
            emit(Resource.Error("Check Internet Connection"))
        }
    }
}