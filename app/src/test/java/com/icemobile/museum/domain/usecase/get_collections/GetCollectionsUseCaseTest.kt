package com.icemobile.museum.domain.usecase.get_collections

import com.google.common.truth.Truth.assertThat
import com.icemobile.museum.common.Response
import com.icemobile.museum.data.FakeData
import com.icemobile.museum.data.repository.FakeCollectionRepository
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import java.io.IOException

class GetCollectionsUseCaseTest {

    lateinit var useCase: GetCollectionsUseCase
    var repository = FakeCollectionRepository()

    var page = 1
    var query = ""

    @Before
    fun setUp() {
        initRepository()
        useCase = GetCollectionsUseCase(repository)
    }

    private fun initRepository(isNetworkError: Boolean = false, isServerError: Boolean = false) {
        repository = FakeCollectionRepository()
        repository.setIsNetworkError(isNetworkError)
        repository.setIsServerError(isServerError)
        repository.fakeCollections = FakeData.getCollectionDTO()
    }

    private fun initUseCase() {
        useCase = GetCollectionsUseCase(repository)
    }

    @Test
    fun `check useCase correct data`() {
        runBlocking {
            val usecaseData = useCase.execute(page, query).drop(1).first()
            val data = usecaseData.data
            assertThat(data).isNotNull()
            assertThat(data?.artObjects).isNotEmpty()
        }
    }

    @Test
    fun `check useCase network error`() {
        initRepository(isNetworkError = true)
        initUseCase()
        runBlocking {
            val usecaseData = useCase.execute(page, query).drop(1).first()
            assertThat(usecaseData).isInstanceOf(Response.Error::class.java)
            assertThat(usecaseData.data).isNull()
            assertThat(usecaseData.message).isEqualTo("Check Internet Connection")
        }
    }

    @Test
    fun `check useCase server error`() {
        initRepository(isServerError = true)
        initUseCase()
        runBlocking {
            val usecaseData = useCase.execute(page, query).drop(1).first()
            assertThat(usecaseData).isInstanceOf(Response.Error::class.java)
            assertThat(usecaseData.data).isNull()
            assertThat(usecaseData.message).isNotEmpty()
        }
    }
}