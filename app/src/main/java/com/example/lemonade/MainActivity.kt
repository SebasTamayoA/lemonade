package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewLemonade()
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = "Lemon Tree",
                    modifier = Modifier.clickable { currentStep = 2 }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.lemon1), fontSize = 24.sp)

            }
        }
        2 -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = "Lemon Squeeze"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.lemon2), fontSize = 24.sp)
            }
        }
        3 -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = "Lemon Drink"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.lemon3), fontSize = 24.sp)
            }
        }
        4 -> {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = "Lemon Restart"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.lemon4), fontSize = 24.sp)
            }
        }
    }

}

@Preview
@Composable
private fun PreviewLemonade() {
    LemonadeTheme {
        LemonadeApp()
    }
}