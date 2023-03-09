import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoveDialog(
    randomLove: Int,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier.width(300.dp),
        shape = MaterialTheme.shapes.large,
        onDismissRequest = {
            onDismiss()
        },
        title = {
            val loveText = when (randomLove) {
                in 0..30 -> "Awful \uD83D\uDE1E("
                in 31..60 -> "Good ) "
                in 61..80 -> "Wonderful \uD83D\uDE18"
                in 81..100 -> "Congratulations \uD83D\uDE0D ❤️"
                else -> ""
            }
            Text(text = loveText, modifier = Modifier.fillMaxWidth())
        },
        text = {
            Text(text = "Your love is $randomLove%", fontSize = 25.sp, color = Color.Red, fontWeight = FontWeight.Bold)
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                  Text(text = "OK")
            }
        }
    )
}