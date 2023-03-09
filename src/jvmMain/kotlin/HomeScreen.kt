import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    var scope = rememberCoroutineScope()
    var boyName by remember {
        mutableStateOf("")
    }
    var girlName by remember {
        mutableStateOf("")
    }
    var isLoading by remember { mutableStateOf(false) }
    var isDialogOpen by remember { mutableStateOf(false) }
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Love Test Game!", color = Color.Red, fontSize = 22.sp)
            OutlinedTextField(
                value = boyName,
                onValueChange = {
                    boyName = it
                },
                label = {
                    Text(text = "Boy name")
                }
            )
            OutlinedTextField(
                value = girlName,
                onValueChange = {
                    girlName = it
                },
                label = {
                    Text(text = "Girl name")
                }
            )
            if (isLoading) {
                CircularProgressIndicator(color = Color.Red)
                scope.launch {
                    delay(2000L)
                    isDialogOpen = true
                    isLoading = false
                }
            } else {
                ExtendedFloatingActionButton(
                    backgroundColor = Color.Red,
                    onClick = {
                        if (boyName.isNotBlank() && girlName.isNotBlank()) {
                            isLoading = true
                        }
                    },
                    text = {
                        Text(text = "Generate Love!")
                    }
                )
            }
        }
    }
    if (isDialogOpen) {
        LoveDialog(
            randomLove = randomLove()
        ) {
            isDialogOpen = false
        }
    }
}
private fun randomLove(): Int = (0..100).random()