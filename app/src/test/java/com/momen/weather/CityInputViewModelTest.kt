package com.momen.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.momen.cityinput.presentation.CityInputViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CityInputViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `setCity updates city LiveData`() {
        val viewModel = CityInputViewModel()

        viewModel.setCity("Cairo")

        assertEquals("Cairo", viewModel.city.value)
    }
}
