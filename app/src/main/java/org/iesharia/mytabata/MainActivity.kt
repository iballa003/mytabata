package org.iesharia.mytabata

import android.R
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.iesharia.mytabata.ui.theme.MytabataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterInit(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun CounterInit(modifier: Modifier = Modifier, setsValue : Int = 0, workValue : Int = 9, restValue: Int = 0){
    var theCounter by remember { mutableStateOf(0L) }
    var miConterDown by remember{ mutableStateOf(CounterDown(workValue, {newvalue -> theCounter = newvalue}))}
    var buttonText by remember{ mutableStateOf("▶")}
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Trabajo",
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp
        )
        Spacer(modifier.padding(10.dp))
        Text(
            text = "0 sets",
            fontSize = 28.sp
        )
        Text(
            text = "00:0"+theCounter.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp
        )
        Spacer(modifier.padding(20.dp))
        Button(onClick = {
            buttonText = "❚❚"
            miConterDown.toggle()
        }) {
            Text(
                //text = "▶",
                text = buttonText,
                fontSize = 28.sp
                )

        }

    }
}
@Composable
fun CounterSetting(modifier: Modifier = Modifier) {
    var setsValue by remember { mutableStateOf(0) }
    var workValue by remember { mutableStateOf(0) }
    var restValue by remember { mutableStateOf(0) }
//    var theCounter by remember { mutableStateOf(0L) }
//    var miConterDown by remember{ mutableStateOf(CounterDown(99, {newvalue -> theCounter = newvalue}))}

//    Column {
//        Text(
//            text = theCounter.toString(),
//            modifier = modifier
//        )
//        Button(onClick = {
//            miConterDown.toggle()
//        }) {
//            Text(
//                text = "Pulsar"
//            )
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Inicio",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Spacer(modifier.padding(20.dp))
        Text(
            text = "Sets",
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row(){
            Text(
                text = "-",
                modifier = Modifier.padding(20.dp)
                    .clickable(onClick = {
                        if (setsValue > 0)
                            setsValue--
                    })
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.maxDimension / 2.0f
                        )
                    },
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = setsValue.toString(),
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "+",
                modifier = Modifier.padding(20.dp)
                    .clickable(onClick = {setsValue++})
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.maxDimension / 2.0f
                        )
                    },
                color = Color.White,
                fontSize = 20.sp,

            )
        }
        Text(
            text = "Trabajo",
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row(){

            Text(
                text = "-",
                modifier = Modifier.padding(20.dp)
                    .clickable(onClick = {
                        if (workValue > 0)
                            workValue--
                    })
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.maxDimension / 2.0f
                        )
                    },
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = workValue.toString(),
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "+",
                modifier = Modifier.padding(20.dp)
                    .clickable(onClick = {workValue++})
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.maxDimension / 2.0f
                        )
                    },
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Text(
            text = "Descanso",
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row(){
            Text(
                text = "-",
                modifier = Modifier.padding(20.dp)
                    .clickable(onClick = {
                        if (restValue > 0)
                            restValue--
                    })
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.maxDimension / 2.0f
                        )
                    },
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = restValue.toString(),
                modifier = Modifier.padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "+",
                modifier = Modifier.padding(20.dp)
                    .clickable(onClick = {restValue++})
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = this.size.maxDimension / 2.0f
                        )
                    },
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.size(60.dp))
        Button(onClick = { Log.i("DAM2","Click")}, shape = RectangleShape) {
            Text(text = "Empezar actividad",
                fontSize = 30.sp)
            modifier.padding(20.dp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MytabataTheme {
        CounterSetting()
    }
}