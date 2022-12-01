package com.inslab.planets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inslab.planets.ui.theme.Satoshi

@Composable
fun HomeScreen(
    onNextButtonClicked: () -> Unit,
    onPrevButtonClicked: () -> Unit,
){
    val wid = LocalConfiguration.current.screenWidthDp;
    Column(
        Modifier
            .fillMaxHeight()
            .width(wid.dp)
            .background(color = Color(0xFF0D1117))
            .padding(top=0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                modifier = Modifier
                    .height(wid.dp/2).shadow(elevation = 30.dp, shape = RectangleShape)
                    .fillMaxWidth().padding(bottom = 24.dp),
                painter = painterResource(id = R.drawable.spce),
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
            )
        }
        Text(
            text = "Welcome to the space program. Let's Explore our universe together",
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = Satoshi,
                fontWeight = FontWeight.Black,
                color = Color(0xFF454C6A),
            ),
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Button(
            onClick = {
                onNextButtonClicked()
            },
            shape = RoundedCornerShape(24),
            colors = buttonColors(backgroundColor = Color(0xFF161B22)),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp).padding(top=24.dp, start = 10.dp, end = 10.dp)
        ){
            Text(
                text = "Explore our galaxy",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFFBABBBD),
                ),
            )
        }
        Button(
            onClick = {
                onPrevButtonClicked()
            },
            shape = RoundedCornerShape(24),
            colors = buttonColors(backgroundColor = Color(0xFF161B22)),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp).padding(top=24.dp, start = 10.dp, end = 10.dp)
        ){
            Text(
                text = "Explore other galaxies....",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFFBABBBD),
                ),
            )
        }
    }
}

