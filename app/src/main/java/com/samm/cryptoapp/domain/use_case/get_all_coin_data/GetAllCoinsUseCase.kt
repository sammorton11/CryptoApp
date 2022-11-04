package com.samm.cryptoapp.domain.use_case.get_all_coin_data

import android.util.Log
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinData>>> = flow {

        try {
            emit(Resource.Loading<List<CoinData>>())
            val coins = repository.getCoinData().map { it.toCoin() }
            emit(Resource.Success<List<CoinData>>(coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<CoinData>>(e.localizedMessage ?: "Unexpected Error"))
        } catch (e: IOException){
            emit(Resource.Error<List<CoinData>>("Check Internet Connection"))
        }
    }
}