package ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
) {

    val viewModel = HomeViewModel(getTrendingTermsUseCase = koinInject())
    val state by viewModel.state



    Scaffold(
        topBar = { TopAppBar(title = { Text("Tenor App") }) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            if (state.trendingTerms?.results != null)
                LazyColumn(
                    modifier = Modifier.padding(vertical = 16.dp),
                ) {
                    items(state.trendingTerms!!.results!!.size) { index ->
                        Text(
                            text = state.trendingTerms!!.results!!.elementAt(index),
                            modifier = Modifier.padding(top = 8.dp),
                            fontSize = 18.sp,
                        )
                    }
                }

        }
    }

}