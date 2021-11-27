package com.icemobile.museum.presentation.list

import com.google.common.truth.Truth.assertThat
import com.icemobile.museum.data.repository.FakeCollectionRepository
import com.icemobile.museum.domain.usecase.get_collections.GetCollectionsUseCase
import com.icemobile.museum.util.uiJob
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before

import org.junit.Test


@ExperimentalCoroutinesApi
class CollectionsViewModelTest {

    private lateinit var viewModel: CollectionsViewModel
    private val repository = FakeCollectionRepository()
    private val useCase = GetCollectionsUseCase(repository)

    private val dispatcher = StandardTestDispatcher()
    private val testScope = TestScope(dispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = CollectionsViewModel(useCase)
    }

    @Test
    fun `check initial values`() {
        assertThat(viewModel.arts.value).isEmpty()
        assertThat(viewModel.query.value).isEmpty()
        assertThat(viewModel.error.value).isEmpty()
        assertThat(viewModel.loading.value).isFalse()
        assertThat(viewModel.page.value).isEqualTo(1)
        assertThat(viewModel.artListScrollPosition).isEqualTo(0)
    }

    @Test
    fun `check nextSearch success`() {
        viewModel.uiJob {
            viewModel.newSearch()
            assertThat(viewModel.arts.value).isEmpty()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}