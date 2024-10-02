package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
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
            LemonTextAndImage(
                textLabelResourceId = R.string.lemon1,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescription = R.string.lemon1,
                onImageClick = { currentStep = 2 }
            )
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
            LemonTextAndImage(
                textLabelResourceId = R.string.lemon2,
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescription = R.string.lemon2,
                onImageClick = { currentStep = 3 }
            )
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
            LemonTextAndImage(
                textLabelResourceId = R.string.lemon3,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescription = R.string.lemon3,
                onImageClick = { currentStep = 4 }
            )
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
            LemonTextAndImage(
                textLabelResourceId = R.string.lemon4,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescription = R.string.lemon4,
                onImageClick = { currentStep = 1 }
            )
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

@Composable
fun LemonTextAndImage(
    textLabelResourceId : Int,
    drawableResourceId : Int,
    contentDescription : Int,
    onImageClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = onImageClick,
                shape = roundedCornerShape(
                    dimensionResource(id = R.dimen.button_corner_radius),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.ternary),
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescription),
                    modifier = Modifier.size(200.dp)
                )
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