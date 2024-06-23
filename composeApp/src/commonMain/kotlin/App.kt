import androidx.compose.runtime.Composable
import application.injection.appModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.core.context.startKoin
import ui.home.HomeScreen

@Composable
@Preview
fun App() {
    startKoin {
        modules(appModule)
    }

    KoinContext {
        HomeScreen()
    }
}