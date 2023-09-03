package com.example.mybasicapp
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var observer: Observer<String>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel()
        viewModel.resultText.observeForever(observer)
    }

    @Test
    fun testCompareTexts_sameTexts() {
        viewModel.compareTexts("test", "test")
        Mockito.verify(observer).onChanged("Los textos son iguales.")
    }

    @Test
    fun testCompareTexts_differentTexts() {
        viewModel.compareTexts("test1", "test2")
        Mockito.verify(observer).onChanged("Los textos son diferentes.")
    }
}
