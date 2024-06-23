package ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.entities.TrendingTerms
import domain.use_case.GetTrendingTermsUseCase
import kotlinx.coroutines.launch


data class HomeState(
    var trendingTerms: TrendingTerms? = null,
    var isLoading: Boolean = true,
)


class HomeViewModel(private val getTrendingTermsUseCase: GetTrendingTermsUseCase) : ViewModel() {
    private var _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state


    fun loadLaunches() {
        viewModelScope.launch {
            try {
                val trendingTerms = getTrendingTermsUseCase.invoke()
                _state.value = HomeState(trendingTerms = trendingTerms, isLoading = false)

            } catch (e: Exception) {
                _state.value = HomeState(isLoading = false)
                throw e
            }
        }
    }

    init {
        loadLaunches()
    }

}