package com.samm.cryptoapp.integration

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.GsonBuilder
import com.samm.cryptoapp.data.remote.CryptoApi
import com.samm.cryptoapp.data.repository.CryptoRepositoryImpl
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Todo: Still learning integration tests -- in-progress

@RunWith(JUnit4::class)
class GetSingleCoinApiTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val server = MockWebServer()
    private lateinit var repository: CryptoRepositoryImpl
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    @Before
    fun setUp(){
        var BASE_URL = server.url("/").toString()

        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)

        repository = CryptoRepositoryImpl(service)
    }


    @Test
    fun test_response(){

        val successResponse = server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(
                    "fake_json_responses/single_coin.json"
                )
        )

        val response = runBlocking { repository.getCoinData() } // todo: malformed JSON -- need to parse the json data
        val json = gson.toJson(successResponse)

        assertTrue(response.isNotEmpty())
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}