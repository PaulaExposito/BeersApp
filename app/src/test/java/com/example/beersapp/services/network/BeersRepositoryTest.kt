package com.example.beersapp.services.network

import com.example.beersapp.services.BeersRepository
import com.example.beersapp.services.network.dao.BeersService
import com.example.beersapp.services.network.dto.BeerApiDTO
import com.example.beersapp.services.network.dto.toBeer
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BeersRepositoryTest {

    @RelaxedMockK
    private lateinit var beersRepository: BeersRepository

    @RelaxedMockK
    private lateinit var api: BeersService


    @Before
    fun onBefore () {
        MockKAnnotations.init(this)
        beersRepository = BeersRepository(api)
    }

    @Test
    fun beersRepository_getBeersFromApi_listSizeIsOfTheSpecifiedSize () = runTest {
        val beersList = getBeers()
        coEvery { api.getBeers(any()) } returns beersList

        val result = beersRepository.getBeers(2)

        coVerify (exactly = 1) { api.getBeers(any()) }

        assertEquals(beersList.size, result.size)
        assertEquals(beersList.first().toBeer(), result.first())
    }

    @Test
    fun beersRepository_castBeerApiDTOToBeer_CastObtainsSameResultOnGetBeers () = runTest {
        val beersList = getBeers()
        coEvery { api.getBeers(any()) } returns beersList

        val result = beersRepository.getBeers(2)

        coVerify (exactly = 1) { api.getBeers(any()) }

        assertEquals(beersList.first().toBeer(), result.first())
    }

    companion object {
        private fun getBeers (): List<BeerApiDTO> {
            return listOf(
                BeerApiDTO(0, "0", "Patagonia", "Sierra Nevada Celebration Ale",
                    "English Pale Ale", "Newport", 	"1028 - London Ale",
                    "Black malt", "79 IBU", "4.9%", "11.4°Blg"),

                BeerApiDTO(1, "1", "Heineken", "Racer 5 India Pale Ale, Bear Republic Bre",
                "Belgian And French Ale", "Newport", 	"1028 - London Ale",
                "Black malt", "79 IBU", "7.3%", "11.4°Blg"),
            )
        }
    }
}