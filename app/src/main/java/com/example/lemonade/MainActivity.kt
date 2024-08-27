package com.example.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
                    LemonadeApp(
                    )
                }
            }
        }
    }


@Preview(showBackground = true)
@Composable
    fun LemonadeApp() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HeaderLemonadeApp(
                title = "Lemonade"
            )
            LemonadeAppWithButtonsAndImages()
        }
}

@Composable
fun HeaderLemonadeApp(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(50.dp),

    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }

}

@Composable
    fun LemonadeAppWithButtonsAndImages(modifier: Modifier = Modifier) {
        var currentStep by remember {
            mutableStateOf(1)
        }

        var squeezeCount by remember { mutableStateOf(0) }

        when(currentStep) {
            1 -> {
                Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = stringResource(R.string.lemon_tree_cd),
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                )
                    Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = stringResource(R.string.lemon_tree)
                )
                }
            }
            2 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                squeezeCount--
                                if (squeezeCount == 0) {
                                    currentStep = 3
                                }
                            }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = stringResource(R.string.lemon_squeeze),
                    )
                }
            }
            3 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemonade_glass),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = stringResource(R.string.lemonade_glass),
                    )
                }
            }
            4 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass_cd),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = stringResource(R.string.empty_glass),
                    )
                }
            }
            }
            }


