package com.samm.cryptoapp.domain.use_case.get_list_of_coins

import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListOfCoinsUseCaseImpl @Inject constructor(
    private val repository: CryptoRepository
): GetListOfCoinsUseCase {

    override operator fun invoke(): Flow<Resource<List<CoinData>>> = flow {

        try {

            emit(Resource.Loading())

            // uses mapper to convert DTO to data model
            val coins = repository.getCoinData().map { it.toCoin() }

            emit(Resource.Success(coins))


        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))

        } catch (e: IOException){
            emit(Resource.Error("Check Internet Connection"))
        }
    }
}