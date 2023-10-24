package com.example.lemonade_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
    var currentStep by remember {mutableStateOf(1)}
    var squeezeCount by remember {mutableStateOf (0)}
    when(currentStep){
        1 -> LemonadeWithImage(
            textLabel = R.string.lemon_tree,
            drawableRes = R.drawable.lemon_tree,
            onImageClick = {
                currentStep =2
                squeezeCount = (2 ..4).random()
            }
        )
        2 -> LemonadeWithImage(
            textLabel = R.string.lemon ,
            drawableRes =R.drawable.lemon_tree ,
            onImageClick = {
                squeezeCount--
                if(squeezeCount ==0){
                    currentStep = 3
                }
            })
        3 -> LemonadeWithImage(
            textLabel =R.string.glass_of_lemonade ,
            drawableRes =R.drawable.lemon_drink ,
            onImageClick = {
                currentStep = 4
            })
        4 -> LemonadeWithImage(
            textLabel = R.string.empty_glass,
            drawableRes =R.drawable.lemon_restart ,
            onImageClick = { 
                currentStep = 1
            })

    }

}

@Composable
fun LemonadeWithImage(textLabel: Int,drawableRes:Int,onImageClick:()->Unit,modifier:Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
){Column(
    modifier = Modifier,
    horizontalAlignment = Alignment.CenterHorizontally
){
    Button(
        onClick = onImageClick
    ){
        Image(
            painter = painterResource(drawableRes),
            contentDescription = null,

            )
    }
    Spacer(modifier = Modifier.height(25.dp))
    Text(
        text = stringResource(textLabel)

    )
}

}
@Preview(showBackground = true)
@Composable
fun LemonPreview(){

        LemonadeApp()

}