package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.lemon_tree_cd)
            )
            Text(
                text = stringResource(R.string.lemon_tree),
                modifier = Modifier
                    .padding(top = 25.dp),
                fontWeight = FontWeight.Bold,
            )
        }
    }

