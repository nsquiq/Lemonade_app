package com.example.lemonade_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade_app.ui.theme.Lemonade_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lemonade_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()

                }
            }
        }
    }
}

@Composable
fun LemonadeApp(){
    LemonadeWithImage()
}

@Preview(showBackground = true)
@Composable
fun LemonadeWithImage(modifier:Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
){Column(
    modifier = Modifier,
    horizontalAlignment = Alignment.CenterHorizontally
){
    Image(
        painter = painterResource(R.drawable.lemon_tree),
        contentDescription = null

    )
    Spacer(modifier = Modifier.height(25.dp))
    Text(
        text = stringResource(R.string.lemon_tree)

    )
}

}